/*
				method����������ʽ��ֵΪget����post
				url:�����ַ
				data:�������ݡ�ʹ�ü�ֵ�Խ��д�ֵ����ͬ�ļ�ֵ��ʹ��&���Ÿ���������:"a=123&b=456";
					���û���������ݣ�����null����
				ansyc:�����첽��ͬ����true��ʾ�첽��false��ʾͬ����Ĭ����true
				deal200:����һ��������������������Ӧ���ݵĺ�����������������һ���β���������ajax����
				deal404:����һ������������������404�ĺ���
				deal500:����һ������������������500����ĺ���
				
			*/
			function myAjax(method,url,data,deal200,deal404,deal500,ansyc){
				//ʹ��ajaxУ���û����Ƿ����
					//����ajax�������
						var ajax;
						if(window.XMLHttpRequest){
							ajax=new XMLHttpRequest();
						}else if(window.ActiveXObject){
							ajax=new ActiveXObject("Msxml2.XMLHTTP");
						}
					//��дonreadystatechange
						ajax.onreadystatechange=function(){
							//�ж�ajax״̬��
								if(ajax.readyState==4){
									//�ж���Ӧ״̬��
									if(ajax.status==200){
										if(deal200){
											deal200(ajax);
										}
									}else if(ajax.status==404){
										if(deal404){
											deal404();
										}
									}else if(ajax.status==500){
										if(deal500){
											deal500();
										}
									}
								}
								
						}
					//��������
						if("get"==method.toLowerCase()){
							//ʹ��get
							ajax.open("get",url+(data==null?"":"?"+data),ansyc);
							//��������
							ajax.send(null);
						}else if("post"==method.toLowerCase()){
							ajax.open("post", url,ansyc);
							ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");	
							ajax.send(data);
						}
						
			}
					