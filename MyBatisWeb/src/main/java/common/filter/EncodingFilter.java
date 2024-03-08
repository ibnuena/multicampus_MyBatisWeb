package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;



@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class EncodingFilter extends HttpFilter implements Filter {
    
	private String charset;
	
	public void init(FilterConfig fConfig) throws ServletException {
		charset=fConfig.getInitParameter("encoding");
//		System.out.println("EncodingFilter init()... charset : " + charset);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("Encoding doFilter()");
		request.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}


	public void destroy() {
//		System.out.println("EncodingFilter destroy()");
	}

}
