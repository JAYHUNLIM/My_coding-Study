<template>
   <div>
    <h1> Key이벤트</h1>
    <input type="search" v-model="searchText" @keyup.enter="doSearch">
    <button @click="doSearch">찾기</button>
    <!-- keyup 이벤트의 세부 속성들 -->
    <!-- .enter  -->
    <!-- .tab -->
    <!-- .space -->
    <!--  .ctrl.enter -->
    <hr>
    <input type="search" v-model="searchText" @keyup="checkEnter($event)">
   </div>
</template>

<script>
/* eslint-disable */
export default {
  data() {
    return {
      searchText: ''
    }
  },
  methods: {
    doSearch() {
      alert(this.searchText)
    },
    checkEnter(event) {
      //alert(event)
      if (event.keyCode === 13) {
        this.doSearch()
      }
    }
  }
}
</script>
