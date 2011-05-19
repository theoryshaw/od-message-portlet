create index IX_B36CA0F9 on OD_QueryAndResponse (parentId);
create index IX_9796DBFF on OD_QueryAndResponse (url);
create index IX_125F79D4 on OD_QueryAndResponse (uuid_);
create unique index IX_CE4FC956 on OD_QueryAndResponse (uuid_, groupId);