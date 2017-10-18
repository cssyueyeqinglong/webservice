服务端自定义webservice步骤：<br>
  1.导入jar包<br>
  2.添加服务类，在方法上加注解：@WebService<br>
  3.发布<br>
    JaxWsServerFactoryBean bean=new JaxWsServerFactoryBean();<br>
    bean.setAddress(""); <br>
    bean.setServiceBean(new MyWebService()); <br>
    bean.create();    <br>
   注意访问的时候后缀需要加上“？wsdl”  </br>
客户端发起请求的步骤：</br>
  1.导入jar包</br>
  2.cmd命令行中运行命令：wsimport -s . http://...</br>
  3.调用远程服务</br>
      //1.生成一个客户端代理工厂
		JaxWsProxyFactoryBean client = new JaxWsProxyFactoryBean();
		
		//2.设置服务端的访问地址
		client.setAddress("http://localhost:12345/weather?wsdl");
		
		//3.设置服务端的接口
		client.setServiceClass(IWeatherService.class);
		
		//4.创建客户端对象
		IWeatherService iws = (IWeatherService) client.create();
		
		//5.调用远程的服务端提供的方法
		String result = iws.getWeatherByCityName("北京");
		
		System.out.println(result);
    
    </br>
    
此外，如果用spring框架整合的话以上客户端和服务端的类便都可以再applicationContext.xml中初始化了
