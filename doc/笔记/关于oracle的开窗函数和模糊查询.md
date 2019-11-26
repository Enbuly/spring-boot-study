
## 关于oracle的开窗函数
    select a.batch_id as batchId, a.system_name as systemName,
    a.applied_user_id as appliedUserId, a.applied_user_name as appliedUserName
    from in_apply a
    where a.batch_id = '20191121';
    根据上面的sql可以查出多条数据，即一个batch_id可能对应多个系统名字、被申请人、被申请人名称。
    要求:一个batch_id只查出一条数据。其余字段取第一条数据的+等展示。
    select * from(
        select a.batch_id as batchId, a.system_name as systemName,
        a.applied_user_id as appliedUserId, a.applied_user_name as appliedUserName,
        row_number()over(partition by a.batch_id order by a.batch_id) as row_num
        from in_apply a
        where a.batch_id = '20191121'
    )f where f.row_num = 1;
    
    
## 关于模糊查询
    select * from user
    where instr(name, 'zz') > 0;
    