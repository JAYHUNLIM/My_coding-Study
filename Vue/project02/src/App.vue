<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <p>
    <img alt="Vue logo" width="300" src="./assets/pepe2.png">
  </p>
  <!-- 데이터 바인딩 1.-->
  <div>
    {{ title }}
  </div>
  <div>
    <h4 style="color:blue">서초원룸</h4>
    <p>{{ price1 }}만원</p>
  </div>

  <div>
    <h4 :style="style1">역삼원룸</h4>
    <p>{{ price2 }}만원</p>

  </div>

  <hr>

  <!-- 데이터 바인딩 2.(배열) -->
  <div>
    <h4>{{ products[0] }}</h4>
    <p>10만원</p>
  </div>

  <div>
    <h4>{{ products[1] }}</h4>
    <p>20만원</p>
  </div>

  <div>
    <h4>{{ products[2] }}</h4>
    <p>30만원</p>
  </div>

  <!-- 3.반복문 -->
  <div class="menu">
    <a>home</a>
    <a>products</a>
    <a>About</a>
  </div>

  <hr>
  <div class="menu">
    <a v-for="m in 3" :key="m">home{{ m }}</a>
  </div>
  <hr>



  <hr>
  <div class="menu">
    <a v-for="menu in menus" :key="menu">home{{ menu }}</a>
  </div>
  <hr>


  <div class="menu">
    <a v-for="(menu, i) in menus" :key="i">{{ i }}</a>
  </div>
  <hr>

  <!-- products를 반복문으로 해보기 -->
  <div v-for="(p, i) in products" :key="i">
    <h4>{{ p }}</h4>
    <p> 10만원 </p>
  </div>
  <hr>

  <!-- 5 이벤트 핸들러 -->
  <div>
    <h4>{{ products[0] }}</h4>
    <p> 10만원
      <!-- <button v-on:click="함수명">허위매물신고</button> -->
      <button @click="report++">허위매물신고</button>
      <span>신고수:{{ report }}</span>
    </p>

  </div>
  <div>
    <h4>{{ products[1] }}</h4>
    <p> 10만원
      <!-- <button v-on:click="함수명">허위매물신고</button> -->
      <button @mouseover="report++">허위매물신고</button>
      <span>신고수:{{ report }}</span>
    </p>

  </div>
<hr>
  <!-- 6 이벤트와 함수 -->
  <div>
    <h4>{{ products[2] }}</h4>
    <p> 40만원
      <button @click="increase">허위매물신고</button>
      <span>신고수:{{ report }}</span>
    </p>

  </div>
  <hr>

  <!-- 7 허위매물신고 각각 동작하기  -->
  <div>
    <h4>{{ products[0] }}</h4>
    <p> 40만원
      <button @click="reportCount[0]++">허위매물신고</button>
      <span>신고수:{{ reportCount[0] }}</span>
    </p>
  </div>


  <div>
    <h4>{{ products[1] }}</h4>
    <p> 40만원
      <button @click="reportCount[1]++">허위매물신고</button>
      <span>신고수:{{ reportCount[1] }}</span>
    </p>
  </div>


  <div>
    <h4>{{ products[2] }}</h4>
    <p> 40만원
      <button @click="reportCount[2]++">허위매물신고</button>
      <span>신고수:{{ reportCount[2] }}</span>
    </p>
  </div>

  <!-- 모달창 만들기 조건문 -->
  <div>
    <h4 @click="modalOpen=true">{{ products[0] }}</h4>
    <p>30만원</p>
  </div>

  <div class="black-bg" v-if="modalOpen==true">
    <div class="white-bg">
      <h4>상세페이지</h4>
      <p>상세페이지 내용</p>
      <button @click="modalOpen=false">닫기</button>
    </div>
  </div>
<hr>

<div>
{{ a }}
<br>
  
{{ b }}

</div>

</template>

<script>

// import 변수명  from 파일경로
//변수를 사용하지 않으면 에러 발생
import {apple,apple2} from './assets/oneroom.js'

// document.getElementById('title').innerText='투룸';
// 기존 javascript, jquery  데이터 바인딩
// $/("#아이디명").text(??)

export default {
  name: 'App',
  components: {

  },
  data() {
    //데이터 보관(변수)
    return {
      title: '원룸샵',
      price1: 60,
      price2: 40,
      style1: 'color : red',
      products: ['신사동 원룸', '논현동 원룸', '강남 원룸'],
      menus: ['HOME', 'SHOP', 'ABOUT'],
      report: 0,
      reportCount: [0, 0, 0],
      modalOpen : false,
      a : apple,
      b : apple2
    }
  },
  methods: {
    increase() {
      this.report += 1;
      //data()에 선언된 변수는 this.변수 접근한다
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.menu {
  background: deepskyblue;
  padding: 15px;
  border-radius: 5px;
}

.menu a {
  color: aliceblue;
  padding: 10px;
}

.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 5);
  padding: 20px;
}

.white-bg {
  width: 100%;
  background: white;
  border-radius: 8px;
  padding: 20px;
}</style>
