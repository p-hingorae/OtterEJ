# OtterEJ


####
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
	</filter>

	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

	<filter>
		<filter-name>realIPFilter</filter-name>
		<filter-class>kr.co.reconers.rsengine.common.wrapper.RealIPFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>realIPFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

	<filter>
		<filter-name>springSecurityFilterChain</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>springSecurityFilterChain</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

	<context-param>
		<param-name>contextClass</param-name>
		<param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
	</context-param>

	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>kr.co.reconers.rsengine.spring.RootConfig</param-value>
	</context-param>
	
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	
	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextClass</param-name>
			<param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
		</init-param>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>kr.co.reconers.rsengine.spring.MvcConfig</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>/*</url-pattern>
	</servlet-mapping>

	<distributable />
	
	####
	
