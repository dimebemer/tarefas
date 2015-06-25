<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="root" value="${pageContext.request.contextPath}"/>

<link rel='stylesheet'
      href='<c:url value="/resources/css/bootstrap.min.css" />' />
<link rel='stylesheet'
      href='<c:url value="/resources/css/dashboard.css" />'/>
<script type="text/javascript"
        src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
<script type="text/javascript"
        src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript">
    var $ROOT = "${root}";
</script>