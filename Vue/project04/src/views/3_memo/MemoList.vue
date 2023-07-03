<template>
   <div>
    <h1> Memo</h1>
    <p>
    <button class="btn btn-primary" @click="getlist">목록</button></p>
    <ul class="list-group">
        <li v-if="memoList.length == 0" class="list-group-item">게시물이 존재하지 않음</li>
        <li v-for="memo in memoList" :key="memo.memono" class="list-group-item"> {{ memo.subject }} <span class="badge"> {{ memo.readcnt }}</span> </li>
    </ul>
   </div>
</template>

<script>
export default {
/* eslint-disable */
  data() {
    return {
      memoList: []
    }
  },
  methods: {
    getlist() {
        //alert("getlist 호출")
        //fetch ajax통신 역할
        //promise 객체는 비동기 작업이 맞이할 미래의 완료 또는 실패와 그결과 값을 반환해 준다
        fetch('http://localhost:9095/memolist').then((response) => { if (response.ok) {
            //alert(response) [object response]
            //alert(response.json()) [object Promise]
            return response.json()
        }}).then((json) => {
            alert(json)
        this.memoList = json })
    }
  }
}
</script>

<style>
@import 'https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css';
</style>
