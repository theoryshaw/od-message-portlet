<%@page import="com.openingdesign.qna.util.QueryAndResponseUtil"%>
<%@page import="com.openingdesign.qna.service.QueryAndResponseLocalServiceUtil"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@include file="/init.jsp" %>

<liferay-ui:header
  title="Queries and Responses"
/>

<portlet:renderURL var="addQueryURL">
  <portlet:param name="jspPage" value="/edit_query.jsp" />
</portlet:renderURL>

<% // ARGHH! The condition below should use the permissionChecker, see slogan example, but then even if
// the role gets assigned to the user accessing the portlet, the user does not have permission :( %>
<c:choose>
	<c:when
		test='<%= user != null && user.getFullName() != null && user.getFullName().length() > 1 %>'>
		<input type="button" value="<liferay-ui:message key="add-query" />"
			onClick="location.href = '<%=addQueryURL.toString()%>';" />
	</c:when>
	<c:otherwise>
		<div class="sign-in-hint">Sign in to respond to queries, or to
		add your own.</div>
	</c:otherwise>
</c:choose>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
%>

<div class="queries-list">
	<liferay-ui:search-container emptyResultsMessage="there-are-no-slogans" delta="20" iteratorURL="<%=iteratorURL %>">
	<liferay-ui:search-container-results>
	<%
		results = QueryAndResponseUtil.getQueries(renderRequest,
						searchContainer.getStart(),
						searchContainer.getEnd());
				total = QueryAndResponseUtil.getQueriesCount(renderRequest);
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
	%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="com.openingdesign.qna.model.QueryAndResponse" keyProperty="queryId" modelVar="query">
	
	<portlet:renderURL windowState="maximized" var="rowURL">
      <portlet:param name="jspPage" value="/edit_query.jsp" />
      <portlet:param name="resourcePrimKey" value="<%= String.valueOf(query.getQueryId()) %>" />
      <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:renderURL>
    
    <liferay-ui:search-container-column-text
      name="query-date"
      property="createdAt"
      orderable="<%=false %>" />

    <liferay-ui:search-container-column-text
      name="created-by"
      property="createdByName"
      orderable="<%=false %>" />

    <liferay-ui:search-container-column-text
      href="<%=rowURL %>"
        name="title"
        property="title"
        orderable="<%= true %>"
        />
	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>

