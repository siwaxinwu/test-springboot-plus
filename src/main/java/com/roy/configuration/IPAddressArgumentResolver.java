package com.roy.configuration;

import com.roy.annotation.IP;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 22:18 2021-03-17
 */
public class IPAddressArgumentResolver extends AbstractNamedValueMethodArgumentResolver {
	@Override
	protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
		IP annotation = parameter.getParameterAnnotation(IP.class);
		return new IPAddressArgumentResolver.RequestIPNamedValueInfo(annotation);
	}

	/**
	 * resolveArgument：这是具体的解析过程，就是从 request 中取出参数的过程，方法的返回值就对应了接口中参数的值。
	 *
	 *
	 * @param name      的名字
	 * @param parameter 参数
	 * @param request   请求
	 * @return {@link Object}
	 * @throws Exception 异常
	 */
	@Nullable
	@Override
	protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
		HttpServletRequest servletRequest = request.getNativeRequest(HttpServletRequest.class);
		String ip = servletRequest.getRemoteAddr();
		return ip == null ? "127.0.0.1":ip;
	}


	/**
	 * supportsParameter方法是检测该参数是否支持这个参数解析器
	 * 如果supportsParameter方法返回true，则调用resolveArgument来进行参数解析工作。
	 * explain: 就是看parameter上面有没有注解IP、parameter的参数类型是不是String，就可以使用这个解析器
	 * @param parameter 参数
	 * @return boolean
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(IP.class)
				&& parameter.getParameterType().isAssignableFrom(String.class);
	}

	private static class RequestIPNamedValueInfo extends NamedValueInfo{

		private RequestIPNamedValueInfo(IP annotation) {
			super(annotation.name(), annotation.required(), annotation.defaultValue());
		}
	}

}