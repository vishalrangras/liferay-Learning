create index IX_63FD22F8 on email_attachment (EMAIL_ATTACHMENT_ID);
create index IX_B4BE98C9 on email_attachment (EMAIL_REMINDER_ID);

create index IX_55005C1A on email_reminder (EMAIL_REMINDER_ID);
create index IX_F532A8D6 on email_reminder (SCHED_TS);
create index IX_5488E481 on email_reminder (STAT_CD);