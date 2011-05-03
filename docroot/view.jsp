<%
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ page import="com.alacrity.openingdesign.messageportlet.model.service.SKQuestionLocalServiceUtil,
                com.alacrity.openingdesign.messageportlet.model.model.SKQuestion,
                java.util.Collection,
                java.util.Date,
                java.text.SimpleDateFormat,
                com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil,
                com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil,
                com.liferay.portal.kernel.dao.orm.OrderFactoryUtil,
                com.liferay.portal.kernel.dao.orm.DynamicQuery,
                com.liferay.portal.model.User,
                com.liferay.portal.service.UserLocalServiceUtil,
                com.alacrity.openingdesign.messageportlet.resources.PageNavigationManager" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<jsp:useBean class="java.lang.String" id="createThreadURL" scope="request" />
<jsp:useBean class="java.lang.String" id="viewThreadURL" scope="request" />
<jsp:useBean class="java.lang.String" id="message" scope="request" />
<jsp:useBean class="java.lang.String" id="pageStart" scope="request" />
<jsp:useBean class="java.lang.String" id="pageEnd" scope="request" />
<jsp:useBean class="java.lang.String" id="pageURL" scope="request" />
<jsp:useBean class="java.lang.String" id="userTime" scope="request" />
<jsp:useBean class="java.lang.String" id="serverTime" scope="request" />

<portlet:defineObjects />

<h2><%=message %></h2>

<form id = "<portlet:namespace />createThread"
action="<%=createThreadURL %>"
method="post">
<input type=submit value="Post new Thread">
</form>
<br>
<%

int start=Integer.parseInt(pageStart);
int end=Integer.parseInt(pageEnd);

DynamicQuery query = DynamicQueryFactoryUtil.forClass(SKQuestion.class)
.add(PropertyFactoryUtil.forName("Parent_ID").eq(new Long(0L)))
.addOrder(OrderFactoryUtil.desc("Post_Date"));

final long maxItems = SKQuestionLocalServiceUtil.getService().dynamicQueryCount(query);

query = DynamicQueryFactoryUtil.forClass(SKQuestion.class)
.add(PropertyFactoryUtil.forName("Parent_ID").eq(new Long(0L)))
.addOrder(OrderFactoryUtil.desc("Post_Date"));

Collection<SKQuestion> questions = SKQuestionLocalServiceUtil.getService().dynamicQuery(query,start,end+1);
%>


<%

SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy hh:mm");

if (questions.size()==0){
    out.print("No threads exist");
} else { %>
<table class=threadsTable>
    <tr>
        <th>Title</th>
        <th>User</th>
        <th>Date</th>
        <th></th>
    </tr>
<%
for (SKQuestion cur : questions){
    
    User user = UserLocalServiceUtil.getUserById(cur.getUser_ID());
%>
    <tr>
        <td><% out.print(cur.getTitle()); %></td>
        <td><% out.print(user.getFullName()); %></td>
        <td><% out.print(format.format(new Date(((Long)(cur.getPost_Date()+(Integer.parseInt(userTime))-(Integer.parseInt(serverTime))))))); %></td>
        <td>
            <form id = "<portlet:namespace />viewThread<%out.print(cur.getPrimaryKey());%>"
                action="<%=viewThreadURL %>"
                method="post">
                <input type=hidden name=threadId value=<%out.print(cur.getPrimaryKey());%> />
                <input type=submit value="View" />
            </form>
        </td>
    </tr>
    
<%
}
%></table><%
}
%>

<div class="navigation">
<form id = "<portlet:namespace />changePage"
action="<%=pageURL %>"
method="post">
<%
final int pagesLeftRight=3;

final int currentPage = PageNavigationManager.calculateCurrentPage(start,end);
final int lastPage = PageNavigationManager.calculateNumberOfPages(start,end,maxItems);

final int startPage=currentPage-pagesLeftRight>0?currentPage-pagesLeftRight:1;
final int endPage=currentPage+pagesLeftRight<=lastPage?currentPage+pagesLeftRight:lastPage;

if(PageNavigationManager.isTherePreviousPages(start,end)){
    %>
    <input type=submit name='pageNumber' value="<%=com.alacrity.openingdesign.messageportlet.modes.Mode.FIRST_PAGE_BUTTON_TEXT %>" />
    <input type=submit name='pageNumber' value="<%=com.alacrity.openingdesign.messageportlet.modes.Mode.PREVIOUS_PAGE_BUTTON_TEXT %>" />
    <%
}

for (int r=startPage;r<currentPage;r++){
    %>
           <input type=submit name='pageNumber' value=<%=r %> />
    <%
}

%>
        <span>&nbsp;<%=currentPage %>&nbsp;</span>
<%

for (int r=currentPage+1;r<=endPage;r++){
    %>
        <input type=submit name='pageNumber' value=<%=r %> />
    <%
}

if (PageNavigationManager.isThereNextPages(start,end,maxItems)){
%>

    <input type=submit name='pageNumber' value="<%=com.alacrity.openingdesign.messageportlet.modes.Mode.NEXT_PAGE_BUTTON_TEXT %>" />
    <input type=submit name='pageNumber' value="<%=com.alacrity.openingdesign.messageportlet.modes.Mode.LAST_PAGE_BUTTON_TEXT %>" />
<%
}
%>
<input type=hidden name=page value=<%=currentPage %> />
<input type=hidden name=lastPage value=<%=lastPage %> />
</form>
</div>
<div class="serverTime">
Server Time: <%=format.format(new Date().getTime()+(Integer.parseInt(serverTime)*60*60*1000)) %>
</div>


