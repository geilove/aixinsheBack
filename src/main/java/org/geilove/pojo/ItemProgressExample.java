package org.geilove.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemProgressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemProgressExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andItemprogressidIsNull() {
            addCriterion("itemProgressID is null");
            return (Criteria) this;
        }

        public Criteria andItemprogressidIsNotNull() {
            addCriterion("itemProgressID is not null");
            return (Criteria) this;
        }

        public Criteria andItemprogressidEqualTo(Long value) {
            addCriterion("itemProgressID =", value, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidNotEqualTo(Long value) {
            addCriterion("itemProgressID <>", value, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidGreaterThan(Long value) {
            addCriterion("itemProgressID >", value, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidGreaterThanOrEqualTo(Long value) {
            addCriterion("itemProgressID >=", value, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidLessThan(Long value) {
            addCriterion("itemProgressID <", value, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidLessThanOrEqualTo(Long value) {
            addCriterion("itemProgressID <=", value, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidIn(List<Long> values) {
            addCriterion("itemProgressID in", values, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidNotIn(List<Long> values) {
            addCriterion("itemProgressID not in", values, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidBetween(Long value1, Long value2) {
            addCriterion("itemProgressID between", value1, value2, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andItemprogressidNotBetween(Long value1, Long value2) {
            addCriterion("itemProgressID not between", value1, value2, "itemprogressid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andItemidIsNull() {
            addCriterion("itemID is null");
            return (Criteria) this;
        }

        public Criteria andItemidIsNotNull() {
            addCriterion("itemID is not null");
            return (Criteria) this;
        }

        public Criteria andItemidEqualTo(Long value) {
            addCriterion("itemID =", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotEqualTo(Long value) {
            addCriterion("itemID <>", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThan(Long value) {
            addCriterion("itemID >", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThanOrEqualTo(Long value) {
            addCriterion("itemID >=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThan(Long value) {
            addCriterion("itemID <", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThanOrEqualTo(Long value) {
            addCriterion("itemID <=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidIn(List<Long> values) {
            addCriterion("itemID in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotIn(List<Long> values) {
            addCriterion("itemID not in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidBetween(Long value1, Long value2) {
            addCriterion("itemID between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotBetween(Long value1, Long value2) {
            addCriterion("itemID not between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andRelationtagIsNull() {
            addCriterion("relationTag is null");
            return (Criteria) this;
        }

        public Criteria andRelationtagIsNotNull() {
            addCriterion("relationTag is not null");
            return (Criteria) this;
        }

        public Criteria andRelationtagEqualTo(Integer value) {
            addCriterion("relationTag =", value, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagNotEqualTo(Integer value) {
            addCriterion("relationTag <>", value, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagGreaterThan(Integer value) {
            addCriterion("relationTag >", value, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagGreaterThanOrEqualTo(Integer value) {
            addCriterion("relationTag >=", value, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagLessThan(Integer value) {
            addCriterion("relationTag <", value, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagLessThanOrEqualTo(Integer value) {
            addCriterion("relationTag <=", value, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagIn(List<Integer> values) {
            addCriterion("relationTag in", values, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagNotIn(List<Integer> values) {
            addCriterion("relationTag not in", values, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagBetween(Integer value1, Integer value2) {
            addCriterion("relationTag between", value1, value2, "relationtag");
            return (Criteria) this;
        }

        public Criteria andRelationtagNotBetween(Integer value1, Integer value2) {
            addCriterion("relationTag not between", value1, value2, "relationtag");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneIsNull() {
            addCriterion("imgAddressOne is null");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneIsNotNull() {
            addCriterion("imgAddressOne is not null");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneEqualTo(String value) {
            addCriterion("imgAddressOne =", value, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneNotEqualTo(String value) {
            addCriterion("imgAddressOne <>", value, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneGreaterThan(String value) {
            addCriterion("imgAddressOne >", value, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneGreaterThanOrEqualTo(String value) {
            addCriterion("imgAddressOne >=", value, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneLessThan(String value) {
            addCriterion("imgAddressOne <", value, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneLessThanOrEqualTo(String value) {
            addCriterion("imgAddressOne <=", value, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneLike(String value) {
            addCriterion("imgAddressOne like", value, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneNotLike(String value) {
            addCriterion("imgAddressOne not like", value, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneIn(List<String> values) {
            addCriterion("imgAddressOne in", values, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneNotIn(List<String> values) {
            addCriterion("imgAddressOne not in", values, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneBetween(String value1, String value2) {
            addCriterion("imgAddressOne between", value1, value2, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddressoneNotBetween(String value1, String value2) {
            addCriterion("imgAddressOne not between", value1, value2, "imgaddressone");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoIsNull() {
            addCriterion("imgAddressTwo is null");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoIsNotNull() {
            addCriterion("imgAddressTwo is not null");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoEqualTo(String value) {
            addCriterion("imgAddressTwo =", value, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoNotEqualTo(String value) {
            addCriterion("imgAddressTwo <>", value, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoGreaterThan(String value) {
            addCriterion("imgAddressTwo >", value, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoGreaterThanOrEqualTo(String value) {
            addCriterion("imgAddressTwo >=", value, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoLessThan(String value) {
            addCriterion("imgAddressTwo <", value, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoLessThanOrEqualTo(String value) {
            addCriterion("imgAddressTwo <=", value, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoLike(String value) {
            addCriterion("imgAddressTwo like", value, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoNotLike(String value) {
            addCriterion("imgAddressTwo not like", value, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoIn(List<String> values) {
            addCriterion("imgAddressTwo in", values, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoNotIn(List<String> values) {
            addCriterion("imgAddressTwo not in", values, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoBetween(String value1, String value2) {
            addCriterion("imgAddressTwo between", value1, value2, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddresstwoNotBetween(String value1, String value2) {
            addCriterion("imgAddressTwo not between", value1, value2, "imgaddresstwo");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeIsNull() {
            addCriterion("imgAddressThree is null");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeIsNotNull() {
            addCriterion("imgAddressThree is not null");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeEqualTo(String value) {
            addCriterion("imgAddressThree =", value, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeNotEqualTo(String value) {
            addCriterion("imgAddressThree <>", value, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeGreaterThan(String value) {
            addCriterion("imgAddressThree >", value, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeGreaterThanOrEqualTo(String value) {
            addCriterion("imgAddressThree >=", value, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeLessThan(String value) {
            addCriterion("imgAddressThree <", value, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeLessThanOrEqualTo(String value) {
            addCriterion("imgAddressThree <=", value, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeLike(String value) {
            addCriterion("imgAddressThree like", value, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeNotLike(String value) {
            addCriterion("imgAddressThree not like", value, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeIn(List<String> values) {
            addCriterion("imgAddressThree in", values, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeNotIn(List<String> values) {
            addCriterion("imgAddressThree not in", values, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeBetween(String value1, String value2) {
            addCriterion("imgAddressThree between", value1, value2, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressthreeNotBetween(String value1, String value2) {
            addCriterion("imgAddressThree not between", value1, value2, "imgaddressthree");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourIsNull() {
            addCriterion("imgAddressFour is null");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourIsNotNull() {
            addCriterion("imgAddressFour is not null");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourEqualTo(String value) {
            addCriterion("imgAddressFour =", value, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourNotEqualTo(String value) {
            addCriterion("imgAddressFour <>", value, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourGreaterThan(String value) {
            addCriterion("imgAddressFour >", value, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourGreaterThanOrEqualTo(String value) {
            addCriterion("imgAddressFour >=", value, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourLessThan(String value) {
            addCriterion("imgAddressFour <", value, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourLessThanOrEqualTo(String value) {
            addCriterion("imgAddressFour <=", value, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourLike(String value) {
            addCriterion("imgAddressFour like", value, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourNotLike(String value) {
            addCriterion("imgAddressFour not like", value, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourIn(List<String> values) {
            addCriterion("imgAddressFour in", values, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourNotIn(List<String> values) {
            addCriterion("imgAddressFour not in", values, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourBetween(String value1, String value2) {
            addCriterion("imgAddressFour between", value1, value2, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfourNotBetween(String value1, String value2) {
            addCriterion("imgAddressFour not between", value1, value2, "imgaddressfour");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveIsNull() {
            addCriterion("imgAddressFive is null");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveIsNotNull() {
            addCriterion("imgAddressFive is not null");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveEqualTo(String value) {
            addCriterion("imgAddressFive =", value, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveNotEqualTo(String value) {
            addCriterion("imgAddressFive <>", value, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveGreaterThan(String value) {
            addCriterion("imgAddressFive >", value, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveGreaterThanOrEqualTo(String value) {
            addCriterion("imgAddressFive >=", value, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveLessThan(String value) {
            addCriterion("imgAddressFive <", value, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveLessThanOrEqualTo(String value) {
            addCriterion("imgAddressFive <=", value, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveLike(String value) {
            addCriterion("imgAddressFive like", value, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveNotLike(String value) {
            addCriterion("imgAddressFive not like", value, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveIn(List<String> values) {
            addCriterion("imgAddressFive in", values, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveNotIn(List<String> values) {
            addCriterion("imgAddressFive not in", values, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveBetween(String value1, String value2) {
            addCriterion("imgAddressFive between", value1, value2, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddressfiveNotBetween(String value1, String value2) {
            addCriterion("imgAddressFive not between", value1, value2, "imgaddressfive");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixIsNull() {
            addCriterion("imgAddressSix is null");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixIsNotNull() {
            addCriterion("imgAddressSix is not null");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixEqualTo(String value) {
            addCriterion("imgAddressSix =", value, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixNotEqualTo(String value) {
            addCriterion("imgAddressSix <>", value, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixGreaterThan(String value) {
            addCriterion("imgAddressSix >", value, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixGreaterThanOrEqualTo(String value) {
            addCriterion("imgAddressSix >=", value, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixLessThan(String value) {
            addCriterion("imgAddressSix <", value, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixLessThanOrEqualTo(String value) {
            addCriterion("imgAddressSix <=", value, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixLike(String value) {
            addCriterion("imgAddressSix like", value, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixNotLike(String value) {
            addCriterion("imgAddressSix not like", value, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixIn(List<String> values) {
            addCriterion("imgAddressSix in", values, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixNotIn(List<String> values) {
            addCriterion("imgAddressSix not in", values, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixBetween(String value1, String value2) {
            addCriterion("imgAddressSix between", value1, value2, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andImgaddresssixNotBetween(String value1, String value2) {
            addCriterion("imgAddressSix not between", value1, value2, "imgaddresssix");
            return (Criteria) this;
        }

        public Criteria andBackuponeIsNull() {
            addCriterion("backupOne is null");
            return (Criteria) this;
        }

        public Criteria andBackuponeIsNotNull() {
            addCriterion("backupOne is not null");
            return (Criteria) this;
        }

        public Criteria andBackuponeEqualTo(String value) {
            addCriterion("backupOne =", value, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeNotEqualTo(String value) {
            addCriterion("backupOne <>", value, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeGreaterThan(String value) {
            addCriterion("backupOne >", value, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeGreaterThanOrEqualTo(String value) {
            addCriterion("backupOne >=", value, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeLessThan(String value) {
            addCriterion("backupOne <", value, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeLessThanOrEqualTo(String value) {
            addCriterion("backupOne <=", value, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeLike(String value) {
            addCriterion("backupOne like", value, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeNotLike(String value) {
            addCriterion("backupOne not like", value, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeIn(List<String> values) {
            addCriterion("backupOne in", values, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeNotIn(List<String> values) {
            addCriterion("backupOne not in", values, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeBetween(String value1, String value2) {
            addCriterion("backupOne between", value1, value2, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuponeNotBetween(String value1, String value2) {
            addCriterion("backupOne not between", value1, value2, "backupone");
            return (Criteria) this;
        }

        public Criteria andBackuptwoIsNull() {
            addCriterion("backupTwo is null");
            return (Criteria) this;
        }

        public Criteria andBackuptwoIsNotNull() {
            addCriterion("backupTwo is not null");
            return (Criteria) this;
        }

        public Criteria andBackuptwoEqualTo(String value) {
            addCriterion("backupTwo =", value, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoNotEqualTo(String value) {
            addCriterion("backupTwo <>", value, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoGreaterThan(String value) {
            addCriterion("backupTwo >", value, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoGreaterThanOrEqualTo(String value) {
            addCriterion("backupTwo >=", value, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoLessThan(String value) {
            addCriterion("backupTwo <", value, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoLessThanOrEqualTo(String value) {
            addCriterion("backupTwo <=", value, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoLike(String value) {
            addCriterion("backupTwo like", value, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoNotLike(String value) {
            addCriterion("backupTwo not like", value, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoIn(List<String> values) {
            addCriterion("backupTwo in", values, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoNotIn(List<String> values) {
            addCriterion("backupTwo not in", values, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoBetween(String value1, String value2) {
            addCriterion("backupTwo between", value1, value2, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackuptwoNotBetween(String value1, String value2) {
            addCriterion("backupTwo not between", value1, value2, "backuptwo");
            return (Criteria) this;
        }

        public Criteria andBackupthreeIsNull() {
            addCriterion("backupThree is null");
            return (Criteria) this;
        }

        public Criteria andBackupthreeIsNotNull() {
            addCriterion("backupThree is not null");
            return (Criteria) this;
        }

        public Criteria andBackupthreeEqualTo(String value) {
            addCriterion("backupThree =", value, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeNotEqualTo(String value) {
            addCriterion("backupThree <>", value, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeGreaterThan(String value) {
            addCriterion("backupThree >", value, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeGreaterThanOrEqualTo(String value) {
            addCriterion("backupThree >=", value, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeLessThan(String value) {
            addCriterion("backupThree <", value, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeLessThanOrEqualTo(String value) {
            addCriterion("backupThree <=", value, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeLike(String value) {
            addCriterion("backupThree like", value, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeNotLike(String value) {
            addCriterion("backupThree not like", value, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeIn(List<String> values) {
            addCriterion("backupThree in", values, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeNotIn(List<String> values) {
            addCriterion("backupThree not in", values, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeBetween(String value1, String value2) {
            addCriterion("backupThree between", value1, value2, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupthreeNotBetween(String value1, String value2) {
            addCriterion("backupThree not between", value1, value2, "backupthree");
            return (Criteria) this;
        }

        public Criteria andBackupfourIsNull() {
            addCriterion("backupFour is null");
            return (Criteria) this;
        }

        public Criteria andBackupfourIsNotNull() {
            addCriterion("backupFour is not null");
            return (Criteria) this;
        }

        public Criteria andBackupfourEqualTo(String value) {
            addCriterion("backupFour =", value, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourNotEqualTo(String value) {
            addCriterion("backupFour <>", value, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourGreaterThan(String value) {
            addCriterion("backupFour >", value, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourGreaterThanOrEqualTo(String value) {
            addCriterion("backupFour >=", value, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourLessThan(String value) {
            addCriterion("backupFour <", value, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourLessThanOrEqualTo(String value) {
            addCriterion("backupFour <=", value, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourLike(String value) {
            addCriterion("backupFour like", value, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourNotLike(String value) {
            addCriterion("backupFour not like", value, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourIn(List<String> values) {
            addCriterion("backupFour in", values, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourNotIn(List<String> values) {
            addCriterion("backupFour not in", values, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourBetween(String value1, String value2) {
            addCriterion("backupFour between", value1, value2, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfourNotBetween(String value1, String value2) {
            addCriterion("backupFour not between", value1, value2, "backupfour");
            return (Criteria) this;
        }

        public Criteria andBackupfiveIsNull() {
            addCriterion("backupFive is null");
            return (Criteria) this;
        }

        public Criteria andBackupfiveIsNotNull() {
            addCriterion("backupFive is not null");
            return (Criteria) this;
        }

        public Criteria andBackupfiveEqualTo(Integer value) {
            addCriterion("backupFive =", value, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveNotEqualTo(Integer value) {
            addCriterion("backupFive <>", value, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveGreaterThan(Integer value) {
            addCriterion("backupFive >", value, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("backupFive >=", value, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveLessThan(Integer value) {
            addCriterion("backupFive <", value, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveLessThanOrEqualTo(Integer value) {
            addCriterion("backupFive <=", value, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveIn(List<Integer> values) {
            addCriterion("backupFive in", values, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveNotIn(List<Integer> values) {
            addCriterion("backupFive not in", values, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveBetween(Integer value1, Integer value2) {
            addCriterion("backupFive between", value1, value2, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupfiveNotBetween(Integer value1, Integer value2) {
            addCriterion("backupFive not between", value1, value2, "backupfive");
            return (Criteria) this;
        }

        public Criteria andBackupsixIsNull() {
            addCriterion("backupSix is null");
            return (Criteria) this;
        }

        public Criteria andBackupsixIsNotNull() {
            addCriterion("backupSix is not null");
            return (Criteria) this;
        }

        public Criteria andBackupsixEqualTo(Integer value) {
            addCriterion("backupSix =", value, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixNotEqualTo(Integer value) {
            addCriterion("backupSix <>", value, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixGreaterThan(Integer value) {
            addCriterion("backupSix >", value, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixGreaterThanOrEqualTo(Integer value) {
            addCriterion("backupSix >=", value, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixLessThan(Integer value) {
            addCriterion("backupSix <", value, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixLessThanOrEqualTo(Integer value) {
            addCriterion("backupSix <=", value, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixIn(List<Integer> values) {
            addCriterion("backupSix in", values, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixNotIn(List<Integer> values) {
            addCriterion("backupSix not in", values, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixBetween(Integer value1, Integer value2) {
            addCriterion("backupSix between", value1, value2, "backupsix");
            return (Criteria) this;
        }

        public Criteria andBackupsixNotBetween(Integer value1, Integer value2) {
            addCriterion("backupSix not between", value1, value2, "backupsix");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}