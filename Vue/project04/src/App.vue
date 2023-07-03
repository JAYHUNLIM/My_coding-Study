<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link> |
    <router-link to="/Welcome">Welcome</router-link> |
    <router-link to="/databinding/String">String</router-link> |
    <router-link to="/databinding/HTML">HTML</router-link> |
    <router-link to="/databinding/Input">Input</router-link> |
    <router-link to="/databinding/Select">Select</router-link> |
    <router-link to="/databinding/CheckBox">CheckBox</router-link> |
    <router-link to="/databinding/Radio">Radio</router-link> |
    <router-link to="/databinding/Attri">Attri</router-link> |
    <router-link to="/databinding/List">List</router-link> |
  <router-link to="/databinding/Class">Class</router-link> |
  <router-link to="/databinding/Style">Style</router-link> |
  <router-link to="/event/Click">Click</router-link> |
  <router-link to="/event/Change">Change</router-link> |
  <router-link to="/event/Key">Key</router-link> |
  <router-link to="/memolist">Memo</router-link> |
  </nav>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
