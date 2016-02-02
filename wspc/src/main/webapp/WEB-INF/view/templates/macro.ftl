<#assign base=request.contextPath />
<#macro html title>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>${title}</title>
<link rel="stylesheet" rev="stylesheet" href="${base}/css/style.css" type="text/css" media="all"/>
</head>
<body>
<div id="Container">
    <div id="Header">
        <div id="logo">这里设置了padding属性介绍一下padding的用法,padding将设置文本与边框的距离。</div>
    </div>
    <div id="Content">
        <div id="Content-Left">Content-Left</div>
        <div id="Content-Main"><#nested/></div>
    </div>
    <div class="Clear"><!--如何你上面用到float,下面布局开始前最好清除一下。--></div>
    <div id="Footer">Footer</div>
</div>
</body>
</html>
</#macro>