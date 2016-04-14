package dw.spring3.rest.bean;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Administrator on 2015/8/7.
 */

@Entity
@XmlRootElement(name = "t_user_info")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "sampleCache1")
/*@TableGenerator(name="t_user_info_Gen",table="GENERATOR_TABLE",pkColumnName="T_KEY",valueColumnName="T_VALUE",pkColumnValue="t_user_info",allocationSize=1)
@Table(name="t_user_info")这里只针对此表进行查询不作新增、删除、修改操作因此将表主键产生器注销掉 */
public class t_user_info implements Serializable {


    private BigInteger user_id;
    private String face;
    private String real_name;
    private String account_name;
    private String account_pwd;
    private BigInteger sex;
    private String mobile_phone;
    private String email;
    private String account_state;
    private BigInteger user_type;
    private BigInteger reg_source;
    private Date last_login_time;
    private String last_login_ip;
    private BigInteger yn;
    private Date created;
    private Date modified;
    private String contact_telephone;
    private Date last_pwd_modified;
    private BigInteger auth_state;
    private BigInteger customer_type;
    private BigInteger pay_account_id;
    private String source_sign;


    @Id
    @GeneratedValue
    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_pwd() {
        return account_pwd;
    }

    public void setAccount_pwd(String account_pwd) {
        this.account_pwd = account_pwd;
    }

    public BigInteger getSex() {
        return sex;
    }

    public void setSex(BigInteger sex) {
        this.sex = sex;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount_state() {
        return account_state;
    }

    public void setAccount_state(String account_state) {
        this.account_state = account_state;
    }

    public BigInteger getUser_type() {
        return user_type;
    }

    public void setUser_type(BigInteger user_type) {
        this.user_type = user_type;
    }

    public BigInteger getReg_source() {
        return reg_source;
    }

    public void setReg_source(BigInteger reg_source) {
        this.reg_source = reg_source;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public BigInteger getYn() {
        return yn;
    }

    public void setYn(BigInteger yn) {
        this.yn = yn;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getContact_telephone() {
        return contact_telephone;
    }

    public void setContact_telephone(String contact_telephone) {
        this.contact_telephone = contact_telephone;
    }

    public Date getLast_pwd_modified() {
        return last_pwd_modified;
    }

    public void setLast_pwd_modified(Date last_pwd_modified) {
        this.last_pwd_modified = last_pwd_modified;
    }

    public BigInteger getAuth_state() {
        return auth_state;
    }

    public void setAuth_state(BigInteger auth_state) {
        this.auth_state = auth_state;
    }

    public BigInteger getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(BigInteger customer_type) {
        this.customer_type = customer_type;
    }

    public BigInteger getPay_account_id() {
        return pay_account_id;
    }

    public void setPay_account_id(BigInteger pay_account_id) {
        this.pay_account_id = pay_account_id;
    }

    public String getSource_sign() {
        return source_sign;
    }

    public void setSource_sign(String source_sign) {
        this.source_sign = source_sign;
    }



}
