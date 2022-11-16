<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <router-link to="/" class="navbar-brand px-5">
        <img alt="Vue logo" src="@/assets/logo.png" style="height:25px;" />
      </router-link>
      <ul class="navbar-nav me-auto">
        <li class="nav-item mx-2"><router-link to="/dealinfo" class="nav-link">실거래가</router-link></li>
        <li class="nav-item mx-2"><router-link to="/post/regForm" class="nav-link">매물</router-link></li>
      </ul>
    </div>
    <div class="d-flex profile-dropdown">
      <div class="dropdown">
        <a href="javascript:void(0);" role="button" data-bs-toggle="dropdown" >
          <img src="@/assets/noProfile.png" alt="프로필 이미지" id="dropdownImg">
        </a>
        <ul class="dropdown-menu dropdown-menu-end shadow border-0 m-0 p-3">
          <li><router-link class="dropdown-item py-2 rounded" to="/myaccount/profile"><i class="fa fa-user me-3"></i>마이 페이지</router-link></li>
          <li><a class="dropdown-item py-2 rounded"><i class="fa fa-info-circle me-3"></i>로그아웃</a></li>
        </ul>
      </div>
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