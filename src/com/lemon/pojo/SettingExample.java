package com.lemon.pojo;

import java.util.ArrayList;
import java.util.List;

public class SettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SettingExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFontSizeIsNull() {
            addCriterion("fontSize is null");
            return (Criteria) this;
        }

        public Criteria andFontSizeIsNotNull() {
            addCriterion("fontSize is not null");
            return (Criteria) this;
        }

        public Criteria andFontSizeEqualTo(Integer value) {
            addCriterion("fontSize =", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotEqualTo(Integer value) {
            addCriterion("fontSize <>", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeGreaterThan(Integer value) {
            addCriterion("fontSize >", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fontSize >=", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLessThan(Integer value) {
            addCriterion("fontSize <", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLessThanOrEqualTo(Integer value) {
            addCriterion("fontSize <=", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeIn(List<Integer> values) {
            addCriterion("fontSize in", values, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotIn(List<Integer> values) {
            addCriterion("fontSize not in", values, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeBetween(Integer value1, Integer value2) {
            addCriterion("fontSize between", value1, value2, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("fontSize not between", value1, value2, "fontSize");
            return (Criteria) this;
        }

        public Criteria andBgcColorIsNull() {
            addCriterion("bgcColor is null");
            return (Criteria) this;
        }

        public Criteria andBgcColorIsNotNull() {
            addCriterion("bgcColor is not null");
            return (Criteria) this;
        }

        public Criteria andBgcColorEqualTo(String value) {
            addCriterion("bgcColor =", value, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorNotEqualTo(String value) {
            addCriterion("bgcColor <>", value, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorGreaterThan(String value) {
            addCriterion("bgcColor >", value, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorGreaterThanOrEqualTo(String value) {
            addCriterion("bgcColor >=", value, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorLessThan(String value) {
            addCriterion("bgcColor <", value, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorLessThanOrEqualTo(String value) {
            addCriterion("bgcColor <=", value, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorLike(String value) {
            addCriterion("bgcColor like", value, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorNotLike(String value) {
            addCriterion("bgcColor not like", value, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorIn(List<String> values) {
            addCriterion("bgcColor in", values, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorNotIn(List<String> values) {
            addCriterion("bgcColor not in", values, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorBetween(String value1, String value2) {
            addCriterion("bgcColor between", value1, value2, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andBgcColorNotBetween(String value1, String value2) {
            addCriterion("bgcColor not between", value1, value2, "bgcColor");
            return (Criteria) this;
        }

        public Criteria andFontFamilyIsNull() {
            addCriterion("fontFamily is null");
            return (Criteria) this;
        }

        public Criteria andFontFamilyIsNotNull() {
            addCriterion("fontFamily is not null");
            return (Criteria) this;
        }

        public Criteria andFontFamilyEqualTo(String value) {
            addCriterion("fontFamily =", value, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyNotEqualTo(String value) {
            addCriterion("fontFamily <>", value, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyGreaterThan(String value) {
            addCriterion("fontFamily >", value, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyGreaterThanOrEqualTo(String value) {
            addCriterion("fontFamily >=", value, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyLessThan(String value) {
            addCriterion("fontFamily <", value, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyLessThanOrEqualTo(String value) {
            addCriterion("fontFamily <=", value, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyLike(String value) {
            addCriterion("fontFamily like", value, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyNotLike(String value) {
            addCriterion("fontFamily not like", value, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyIn(List<String> values) {
            addCriterion("fontFamily in", values, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyNotIn(List<String> values) {
            addCriterion("fontFamily not in", values, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyBetween(String value1, String value2) {
            addCriterion("fontFamily between", value1, value2, "fontFamily");
            return (Criteria) this;
        }

        public Criteria andFontFamilyNotBetween(String value1, String value2) {
            addCriterion("fontFamily not between", value1, value2, "fontFamily");
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