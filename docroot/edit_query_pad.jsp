<%@include file="/init.jsp"%>

<portlet:renderURL windowState="normal" var="backUrl">
	<portlet:param name="jspPage" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<%
	QueryAndResponse query = (QueryAndResponse) request
			.getAttribute(WebKeys.QUERY_ENTRY);
	System.out.println("query: " + query);
%>

<liferay-ui:header backURL="<%= backUrl %>"
	title="<%= \"Edit Query: \" + query.getTitle() %>" />

<div class="query-editable"><iframe
	src="<%=query.getUrl()%>">IFrames not supported,
unable to edit query.</iframe></div>
