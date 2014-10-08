select customer from Customer customer where customer.id in 
	(select innerCustomer.id from Customer innerCustomer 
		where (select count(aclEntry) from AclEntry aclEntry where 
			aclEntry.aclObjectIdentity = (select aclObjectIdentity from AclObjectIdentity aclObjectIdentity where aclObjectIdentity.objectIdIdentity = customer.id and aclObjectIdentity.objectIdClass = (select aclClass 
from AclClass aclClass where aclClass.objectClass = 'com.acme.Customer')) and 
			aclEntry.granting = 'true' and 
			aclEntry.sid in (select aclSid from AclSid aclSid where aclSid.sid in (:sids))) > 0) 
