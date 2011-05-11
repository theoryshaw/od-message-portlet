<%@page import="com.openingdesign.qna.model.impl.QueryAndResponseImpl"%>
<%@include file="/init.jsp"%>

<portlet:renderURL windowState="normal" var="backUrl">
	<portlet:param name="jspPage" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="<%= backUrl %>" title="Query: Title / Categories / Tags" />

<%
	QueryAndResponse query = (QueryAndResponse) request
			.getAttribute(WebKeys.QUERY_ENTRY);
	String submitLabel = "Save";
	if (query == null) {
		query = new QueryAndResponseImpl();
		submitLabel = "Create Query...";
	}
	String redirect = ParamUtil.getString(request, "redirect");
%>

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="updateQuery" var="updateQueryURL">
	<portlet:param name="redirect" value="<%= redirect %>" />
	<portlet:param name="resourcePrimKey"
		value="<%= String.valueOf(query.getQueryId()) %>" />
</portlet:actionURL>

<aui:form name="fm" action="<%= updateQueryURL.toString() %>"
	method="post">

	<aui:fieldset>
		<aui:model-context bean="<%= query %>"
			model="<%= QueryAndResponse.class %>" />

		<aui:input name="queryId" type="hidden" />
		<h1>The Query</h1>
		<liferay-ui:error key="title-required" message="title-required" />
		<aui:input name="title" first="true" autoFocus="true" size="65" />
		<aui:input name="categories" type="assetCategories" />
		<aui:input name="tags" type="assetTags" />

		<aui:button-row>
			<c:if
				test='<%= query.getQueryId() == 0 || query.getUserId() == user.getUserId() %>'>
				<aui:button value="<%= submitLabel %>" type="submit" />
			</c:if>
			<aui:button type="cancel" value="Cancel" onClick="<%= cancelURL %>" />
		</aui:button-row>

	</aui:fieldset>

</aui:form>

