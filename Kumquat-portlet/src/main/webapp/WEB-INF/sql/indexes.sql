create index IX_C1E481CC on Kumquat_ContactGroup (companyId, groupId);

create index IX_CC7AB73F on Kumquat_ContactInfo (contactGroupId, companyId, groupId);
create index IX_2C0E572B on Kumquat_ContactInfo (contactGroupId, emailAddress, companyId, groupId);