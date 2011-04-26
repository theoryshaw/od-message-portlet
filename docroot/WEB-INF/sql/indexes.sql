create index IX_6EAAD412 on PR_PRProduct (companyId);
create index IX_DA9D3714 on PR_PRProduct (groupId);
create index IX_C7EFF736 on PR_PRProduct (groupId, productName);

create index IX_53C80A55 on SK_SKQuestion (Parent_ID);
create index IX_68B9B3D9 on SK_SKQuestion (Question_ID);
create index IX_3CB7F174 on SK_SKQuestion (Url);