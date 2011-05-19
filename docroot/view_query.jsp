<%@include file="/init.jsp"%>
<%@page import="com.openingdesign.qna.util.QueryAndResponseUtil"%>
<%@page import="com.openingdesign.qna.service.QueryAndResponseLocalServiceUtil"%>
<%@page import="javax.portlet.RenderResponse"%>

<portlet:renderURL windowState="normal" var="backUrl">
	<portlet:param name="jspPage" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<%
	QueryAndResponse query = (QueryAndResponse) request
			.getAttribute(WebKeys.QUERY_ENTRY);
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header backURL="<%= backUrl %>"
	title="<%= \"The Query: \" + query.getTitle() %>" />

<portlet:renderURL var="editQueryURL">
	<portlet:param name="jspPage" value="/edit_query.jsp" />
	<portlet:param name="resourcePrimKey"
		value="<%= String.valueOf(query.getQueryId()) %>" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>

<portlet:renderURL var="editPadURL">
	<portlet:param name="jspPage" value="/edit_query_pad.jsp" />
	<portlet:param name="resourcePrimKey"
		value="<%= String.valueOf(query.getQueryId()) %>" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>

<portlet:actionURL name="addResponse" var="addResponseURL">
	<portlet:param name="resourcePrimKey"
		value="<%= String.valueOf(query.getQueryId()) %>" />
</portlet:actionURL>

<c:if test='<%= query.getUserId() == user.getUserId() %>'>
	<input type="button" value="<liferay-ui:message key="edit-query" />"
		onClick="location.href = '<%=editQueryURL.toString()%>';" />
	<input type="button" value="<liferay-ui:message key="edit-pad" />"
		onClick="location.href = '<%=editPadURL.toString()%>';" />
</c:if>

<div class="query-view">

<div class="query-readonly"><iframe
	src="<%=query.getHistoryURL()%>">IFrames not supported, unable
to view query content.</iframe></div>

<div class="details-and-responses">

<div class="query-details">
<div class="title"><%=query.getTitle()%></div>
<div class="by">by <%=query.getCreatedByName()%></div>
<div class="created-at">created <%=query.getCreatedAt()%></div>
</div>

<div class="responses">

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
%>

	<liferay-ui:search-container emptyResultsMessage="there-are-no-responses" delta="20" iteratorURL="<%=iteratorURL %>">
	<liferay-ui:search-container-results>
	<%
		results = QueryAndResponseUtil.getResponsesForQuery(renderRequest, query.getQueryId());
		total = results.size();
		pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
	%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="com.openingdesign.qna.model.QueryAndResponse" keyProperty="queryId" modelVar="r">
	
	<portlet:renderURL windowState="maximized" var="rowURL">
      <portlet:param name="jspPage" value="/edit_response.jsp" />
      <portlet:param name="responsePrimKey" value="<%= String.valueOf(r.getQueryId()) %>" />
      <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:renderURL>
    
    <liferay-ui:search-container-column-text
      href="<%=rowURL %>"
      name="html-representation-responses"
      property="htmlRepresentationShortened"
      orderable="<%=false %>" />

    <liferay-ui:search-container-column-text
      href="<%=rowURL %>"
      name="created-by"
      property="createdByName"
      orderable="<%=false %>" />

    <liferay-ui:search-container-column-text
      name="query-date"
      property="createdAt"
      orderable="<%=false %>" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	</liferay-ui:search-container>

</div>

<div class="respond"><c:choose>
	<c:when
		test='<%= user != null && user.getFullName() != null && user.getFullName().length() > 1 %>'>
		<input type="button" value="<liferay-ui:message key="add-response" />"
			onClick="location.href = '<%=addResponseURL.toString()%>';" />
	</c:when>
	<c:otherwise>
		<div class="sign-in-hint">Sign in to respond to queries.</div>
	</c:otherwise>
</c:choose></div>

</div>

</div>