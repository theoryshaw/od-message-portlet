<%@include file="/init.jsp"%>

<portlet:renderURL windowState="normal" var="backUrl">
	<portlet:param name="jspPage" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<%
	QueryAndResponse query = (QueryAndResponse) request
			.getAttribute(WebKeys.QUERY_ENTRY);
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header backURL="<%= backUrl %>" title="<%= \"The Query: \" + query.getTitle() %>" />

<portlet:renderURL var="editQueryURL">
  <portlet:param name="jspPage" value="/edit_query.jsp" />
  <portlet:param name="resourcePrimKey" value="<%= String.valueOf(query.getQueryId()) %>" />
  <portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>

<portlet:renderURL var="editPadURL">
  <portlet:param name="jspPage" value="/edit_query_pad.jsp" />
  <portlet:param name="resourcePrimKey" value="<%= String.valueOf(query.getQueryId()) %>" />
  <portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>

<c:if test='<%= query.getUserId() == user.getUserId() %>'>
<input type="button" value="<liferay-ui:message key="edit-query" />"
			onClick="location.href = '<%=editQueryURL.toString()%>';" />
<input type="button" value="<liferay-ui:message key="edit-pad" />"
			onClick="location.href = '<%=editPadURL.toString()%>';" />
</c:if>

<div class="query-view">
<div class="query-readonly">
<iframe src="<%= query.getHistoryURL() %>">IFrames not supported, unable to view query content.</iframe>
</div>
<div class="details-and-responses">
Here details of query and list of responses.
</div>
</div>