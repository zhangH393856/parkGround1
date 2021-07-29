package com.park.pojo;

import java.util.ArrayList;
import java.util.List;

public class LineTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LineTableExample() {
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

        public Criteria andLineParknameIsNull() {
            addCriterion("line_parkName is null");
            return (Criteria) this;
        }

        public Criteria andLineParknameIsNotNull() {
            addCriterion("line_parkName is not null");
            return (Criteria) this;
        }

        public Criteria andLineParknameEqualTo(String value) {
            addCriterion("line_parkName =", value, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameNotEqualTo(String value) {
            addCriterion("line_parkName <>", value, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameGreaterThan(String value) {
            addCriterion("line_parkName >", value, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameGreaterThanOrEqualTo(String value) {
            addCriterion("line_parkName >=", value, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameLessThan(String value) {
            addCriterion("line_parkName <", value, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameLessThanOrEqualTo(String value) {
            addCriterion("line_parkName <=", value, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameLike(String value) {
            addCriterion("line_parkName like", value, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameNotLike(String value) {
            addCriterion("line_parkName not like", value, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameIn(List<String> values) {
            addCriterion("line_parkName in", values, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameNotIn(List<String> values) {
            addCriterion("line_parkName not in", values, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameBetween(String value1, String value2) {
            addCriterion("line_parkName between", value1, value2, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineParknameNotBetween(String value1, String value2) {
            addCriterion("line_parkName not between", value1, value2, "lineParkname");
            return (Criteria) this;
        }

        public Criteria andLineUsernameIsNull() {
            addCriterion("line_userName is null");
            return (Criteria) this;
        }

        public Criteria andLineUsernameIsNotNull() {
            addCriterion("line_userName is not null");
            return (Criteria) this;
        }

        public Criteria andLineUsernameEqualTo(String value) {
            addCriterion("line_userName =", value, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameNotEqualTo(String value) {
            addCriterion("line_userName <>", value, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameGreaterThan(String value) {
            addCriterion("line_userName >", value, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("line_userName >=", value, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameLessThan(String value) {
            addCriterion("line_userName <", value, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameLessThanOrEqualTo(String value) {
            addCriterion("line_userName <=", value, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameLike(String value) {
            addCriterion("line_userName like", value, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameNotLike(String value) {
            addCriterion("line_userName not like", value, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameIn(List<String> values) {
            addCriterion("line_userName in", values, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameNotIn(List<String> values) {
            addCriterion("line_userName not in", values, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameBetween(String value1, String value2) {
            addCriterion("line_userName between", value1, value2, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineUsernameNotBetween(String value1, String value2) {
            addCriterion("line_userName not between", value1, value2, "lineUsername");
            return (Criteria) this;
        }

        public Criteria andLineStateIsNull() {
            addCriterion("line_state is null");
            return (Criteria) this;
        }

        public Criteria andLineStateIsNotNull() {
            addCriterion("line_state is not null");
            return (Criteria) this;
        }

        public Criteria andLineStateEqualTo(String value) {
            addCriterion("line_state =", value, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateNotEqualTo(String value) {
            addCriterion("line_state <>", value, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateGreaterThan(String value) {
            addCriterion("line_state >", value, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateGreaterThanOrEqualTo(String value) {
            addCriterion("line_state >=", value, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateLessThan(String value) {
            addCriterion("line_state <", value, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateLessThanOrEqualTo(String value) {
            addCriterion("line_state <=", value, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateLike(String value) {
            addCriterion("line_state like", value, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateNotLike(String value) {
            addCriterion("line_state not like", value, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateIn(List<String> values) {
            addCriterion("line_state in", values, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateNotIn(List<String> values) {
            addCriterion("line_state not in", values, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateBetween(String value1, String value2) {
            addCriterion("line_state between", value1, value2, "lineState");
            return (Criteria) this;
        }

        public Criteria andLineStateNotBetween(String value1, String value2) {
            addCriterion("line_state not between", value1, value2, "lineState");
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