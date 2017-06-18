# SOACode
服务计算与SOA课程编程作业

## Assignment2 Schema设计
设计关于学生信息的相关schema，要求<br/>

 1. 按要求分离公共数据
 2. 数据结构合理且满足实际应用需求
 3. 使用任意工具（WTP XML Schema Editor）

以小组中学号最小的同学作为例，编写一个符合Student.xsd数据类型的XML文档1

设计StudentList.xsd

## Assignment3 Processing XML （DOM）
 1. 采用DOM生成符合StudentList.xsd要求的XML文档2
 2. 除写入Assignment2 中的XML文档1 的同学信息外，还需要加入本小组及相邻前后两组中其他同学的相关信息，并为每位同学随机生成五门课程的成绩（包含平时成绩、期末成绩和总评成绩），要求至少有部分同学，任意成绩低于60分

## Assignment4 Processing XML （XSLT&SAX）
 1. 采用XSLT将该XML文档转换为符合ScoreList.xsd格式要求的成绩册文档XML文档3，并依据成绩对每门课程进行排序
 2. 采用SAX处理XML文档3 ，仅保留出现任意不及格成绩的课程成绩记录，保存为XML文档4
 3. 注意：如相关schema与ScoreList.xsd不兼容，则需要对相关schema作出修改

## Assignment 5 SOAP Message（Response MEP）
使用Servlet, 遵循SOAP Response message exchange pattern 按照学号查询学生成绩<br/>

要求：<br/>

 1. 使用HTTP绑定，以带参数的GET方法传递学号，并返回以SOAP封装的学生成绩信息
 2. 如发生错误，则返回恰当的SOAP报错消息

## Assignment 6 SOAP Message（Request Response MEP）
改写Assignment 5中的Servlet, 遵循SOAP request-response message exchange pattern 修改学生成绩<br/>

要求:<br/>

 1. 采用HTTP绑定，使用POST方法传递成绩修改信息（SOAP封装），并返回修改后的相关成绩列表（SOAP封装）
 2. 如发生错误，则返回恰当的SOAP报错消息
 3. 编写客户端（e.g. HttpURLConnection），完成与Servlet的交互，并输出返回结果或出错信息

## Assignment 7 WSDL （包装现有服务）
使用WSDL 2.0 描述Assignment 5、6中实现的服务，并在interface中添加其他operation，使成绩管理服务功能完备<br/>

以小组为单位，提交WSDL组件模型相关文档（可能包括一系列WSDL文档和Schema文档），要求：<br/>

 1. 相应的WSDL组件的namespace定义在http://jw.nju.edu.cn/wsdl下
 2. 遵循数据模型分离原则，使用Schema定义公共数据结构，并采用import组装
 3. 如果必要，采用模块化方式定义WSDL组件，并采用import组装
 4. 注意namespace的使用，并注意定义错误
 5. 要求引用在以往作业中定义的Schema，如有必要，可以对原有Schema进行修改

## Assignment 8 WSDL （全新设计）
使用WSDL 2.0 描述学生个人信息管理服务<br/>

使用WSDL 2.0 描述学生账号认证服务<br/>

以小组为单位，提交WSDL组件模型相关文档（可能包括一系列WSDL文档和Schema文档），要求：<br/>

 1. 相应的WSDL组件的namespace定义在http://jw.nju.edu.cn/wsdl下
 2. 遵循数据模型分离原则，使用Schema定义公共数据结构，并采用import组装
 3. 如果必要，采用模块化方式定义WSDL组件，并采用import组装
 4. 注意namespace的使用，并注意定义错误
 5. 要求引用在以往作业中定义的Schema，如有必要，可以对原有Schema进行修改

## Assignment 9 The JAXB 2.0 Data Binding
采用JAXB重做Assignment 3&4，使用JAXB完成XML文档1~XML文档4之间的转换。<br/>

要求：<br/>

 1. 提交相关脚本、程序
 2. 其他要求同Assignment 3&4

## Assignment 10 Server-Side Development
采用Start from WSDL或者Start from WSDL and Java模式，实现作业7,8完成WSDL所描述的服务<br/>

采用Start from Java模式，实现通过邮箱Login的功能<br/>

要求：<br/>

 1. 要求Login服务验证邮箱身份（老师、研究生、本科生）
 2. 注意出错处理。有必要时可以修改原有WSDL
 3. 确保服务在学院内网的可访问性
