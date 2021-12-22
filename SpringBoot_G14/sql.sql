create table transaction1(
	id varchar2(20),
	amount number(10)
	);
	create table transaction2(
	id varchar2(20),
	amount number(10)
	);
	create table transaction3(
	id varchar2(20),
	amount number(10)
	);
	
	select * from transaction1;
	select * from transaction2;
	select * from transaction3;
	
	delete  from  transaction1;
	delete  from  transaction2;
	delete  from  transaction3;
	
	--@Transactional(propagation=Propagation.REQUIRED) //관련작업 모두 취소
	--//@Transactional(propagation=Propagation.REQUIRES_NEW) //현재작업은 독립실행