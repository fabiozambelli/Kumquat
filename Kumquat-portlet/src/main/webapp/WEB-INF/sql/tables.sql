create table Kumquat_ContactGroup (
	contactGroupId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table Kumquat_ContactInfo (
	contactInfoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	telephoneNumber VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	agreedToPrivacy BOOLEAN,
	contactGroupId LONG
);