<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <router-link to="/" class="navbar-brand px-5">
        <img alt="Vue logo" src="@/assets/logo.png" style="height:25px;" />
      </router-link>
      <ul class="navbar-nav me-auto">
        <li class="nav-item mx-2"><router-link to="/dealinfo" class="nav-link">실거래가</router-link></li>
        <li class="nav-item mx-2"><router-link to="/houseitem" class="nav-link">매물</router-link></li>
      </ul>
    </div>

    <div class="dropdown">
      <b-dropdown id="dropdown-1" dropleft class="m-2">
        <b-dropdown-item>관심 매물</b-dropdown-item>
        <b-dropdown-divider></b-dropdown-divider>
        <b-dropdown-item>회원 정보 수정</b-dropdown-item>
        <b-dropdown-item>로그아웃</b-dropdown-item>
      </b-dropdown>
    </div>
  </nav>

</template>

<script>
</script>

<style scoped>

ul a{
  border-radius: 10px;
}

ul li{
  margin: 0 5px;
}

ul a.router-link-exact-active {
  color: white;
  background: black;
  font-weight: bold;
}

ul a:hover {
  background: grey;
}

#dropdownImg{
  width: 35px;
  height: 35px;
  border: 1px solid black;
  border-radius: 100%;
  margin-right: 30px;
}
</style>