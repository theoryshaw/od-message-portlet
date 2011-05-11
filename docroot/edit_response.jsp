<%@include file="/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	QueryAndResponse query = (QueryAndResponse) request
			.getAttribute(WebKeys.QUERY_ENTRY);
	QueryAndResponse r = (QueryAndResponse) request
			.getAttribute(WebKeys.QUERY_RESPONSE);
	System.out.println("query: " + query + ", response: " + r);
%>

<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/view_query.jsp" />
	<portlet:param name="resourcePrimKey"
		value="<%= String.valueOf(query.getQueryId()) %>" />
</portlet:renderURL>

<liferay-ui:header backURL="<%= backURL %>"
	title="<%= query.getCreatedByName() + \": \" 
	+ query.getTitle() + \" (Response by \" + r.getCreatedByName() + \")\" %>" />

<div class="response-editable"><iframe
	src="<%=r.getUrl()%>">IFrames not supported,
unable to edit query.</iframe></div>
