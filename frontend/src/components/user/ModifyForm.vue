<template>
  <div class="mt-5 mb-5">
    <b-row>
      <b-col></b-col>
      <b-col>
        <b-card>
          <b-row class="mt-3 mb-3 text-left">
            <b-col sm="1"></b-col>
            <b-col>
              <h3 class="mb-5">회원 정보 수정</h3>
              <b-col>
                <b-form-group
                  id="input-group-userId"
                  label="아이디"
                  label-for="input-userId"
                  class="mb-3"
                >
                  <b-row>
                    <b-col>
                      <b-form-input
                        id="input-userId"
                        v-model="form.userId"
                        type="email"
                        disabled
                      ></b-form-input>
                    </b-col>
                  </b-row>
                </b-form-group>
              </b-col>

              <b-form-group id="input-group-name" label="이름:" label-for="input-name" class="mb-3">
                <b-form-input
                  id="input-name"
                  v-model="form.userName"
                  :lazy="true"
                  :state="validate.userName"
                  maxlength="40"
                ></b-form-input>
                <b-form-invalid-feedback :state="validate.userName">
                  {{ feedBack.userName }}
                </b-form-invalid-feedback>
              </b-form-group>

              <b-form-group
                id="input-birthDay-group"
                label="생년월일"
                label-for="input-year"
                class="mb-3"
              >
                <b-row>
                  <b-col>
                    <b-form-input
                      id="input-year"
                      v-model="birthDay.year"
                      :lazy="true"
                      type="text"
                      placeholder="년(4자)"
                      maxlength="4"
                    ></b-form-input>
                  </b-col>

                  <b-col>
                    <b-form-select
                      class="full-size"
                      id="input-month"
                      v-model="birthDay.month"
                      :options="months"
                    ></b-form-select>
                  </b-col>

                  <b-col>
                    <b-form-input
                      id="input-day"
                      v-model="birthDay.day"
                      type="text"
                      placeholder="일"
                      maxlength="2"
                      :lazy="true"
                    ></b-form-input>
                  </b-col>
                </b-row>
                <b-form-invalid-feedback :state="validate.birthDay">
                  {{ feedBack.birthDay }}
                </b-form-invalid-feedback>
              </b-form-group>

              <b-form-group
                id="input-gender-group"
                label="성별"
                label-for="input-gender"
                class="mb-3"
              >
                <b-form-select
                  class="full-size"
                  style="height: 40px"
                  id="input-gender"
                  v-model="form.gender"
                  :options="genders"
                ></b-form-select>
                <b-form-invalid-feedback :state="validate.gender">
                  {{ feedBack.gender }}
                </b-form-invalid-feedback>
              </b-form-group>
              <b-row>
                <b-col></b-col>
                <b-col sm="3">
                  <b-button variant="success" @click="modify">수정하기</b-button>
                </b-col>
              </b-row>
            </b-col>
            <b-col sm="1"></b-col>
          </b-row>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </div>
</template>

<script>
import { apiInstance } from "@/api/index.js";
import router from "@/router";
import { mapState, mapMutations } from "vuex";

let axios = apiInstance();

const requiredMsg = "필수 정보입니다.";
const nameTest = /^[가-힣a-zA-Z]+$/;
const numberTest = /^[0-9]+$/;

const maxDayInMonth = {
  1: 31,
  3: 31,
  4: 30,
  5: 31,
  6: 30,
  7: 31,
  8: 31,
  9: 30,
  10: 31,
  11: 30,
  12: 31,
};
export default {
  data() {
    return {
      form: {
        userId: "",
        userName: "",
        gender: "",
      },
      birthDay: {
        year: "",
        month: null,
        day: "",
      },
      months: [{ text: "월", value: null }, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
      genders: [{ text: "성별", value: null }, "남", "여", "선택안함"],
      feedBack: {
        id: requiredMsg,
        userName: requiredMsg,
        birthDay: requiredMsg,
        gender: requiredMsg,
      },
      validate: {
        id: true,
        userName: true,
        birthDay: true,
        gender: true,
      },
    };
  },
  computed: {
    ...mapState('userStore', ['userinfo'])
  },
  created() {
    console.log("created!");
    this.birthDay.year = this.userinfo.birthYear;
    this.birthDay.month = this.userinfo.birthMonth;
    this.birthDay.day = this.userinfo.birthDay;
    this.form.userId = this.userinfo.userId;
    this.form.userName = this.userinfo.userName;
    this.form.gender = this.userinfo.gender;
    console.log("create finish!");
  },
  watch: {
    "form.userName": function () {
      this.validate.userName = this.isValidName();
    },
    "birthDay.year": async function () {
      console.log("year");
      this.validate.birthDay = await this.isValidBirthDay();
    },
    "birthDay.month": async function () {
      console.log("month");
      this.validate.birthDay = await this.isValidBirthDay();
    },
    "birthDay.day": async function () {
      console.log("day");
      this.validate.birthDay = await this.isValidBirthDay();
    },
    "form.gender": function (newval, oldval) {
      this.validate.gender = !newval ? false : true;
    },
  },
  methods: {
    isValidName() {
      let nameck = this.form.userName;
      if (!nameck || nameck.length == 0) {
        this.feedBack.userName = requiredMsg;
        return false;
      }
      if (!nameTest.test(nameck)) {
        this.feedBack.userName = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        return false;
      }
      return true;
    },
    async isValidBirthDay() {
      let birthDaychk = this.birthDay;
      console.log(birthDaychk.year);
      // year check
      if (!birthDaychk.year || birthDaychk.year.length != 4 || !numberTest.test(birthDaychk.year)) {
        this.validate.birthDay = false;
        this.feedBack.birthDay = "태어난 년도 4자리를 정확하게 입력하세요.";
        console.log("zz");
        return false;
      }
      if (Number(birthDaychk.year) < 1900) {
        this.validate.birthDay = false;
        this.feedBack.birthDay = "정말인가요?";
        return false;
      }
      // month check
      if (!birthDaychk.month) {
        this.validate.birthDay = false;
        this.feedBack.birthDay = "태어난 월을 선택하세요.";
        return false;
      }

      // day check
      let maxDay = -1;
      if (birthDaychk.month == 2) this.isLeapYear() ? (maxDay = 29) : (maxDay = 28);
      else maxDay = maxDayInMonth[birthDaychk.month];

      if (
        !birthDaychk.day ||
        birthDaychk.day.length == 0 ||
        !numberTest.test(birthDaychk.day) ||
        Number(birthDaychk.day) > maxDay
      ) {
        this.validate.birthDay = false;
        this.feedBack.birthDay = "태어난 일(날짜)을 정확하게 입력하세요.";
        return false;
      }

      let curtime = await axios
        .get("/api/times")
        .then(({ data }) => {
          //console.log(data);
          return data.split("/");
        })
        .catch((error) => {
          console.log(error);
          return false;
        });

        let flag = true;

        if (Number(curtime.year) < Number(this.birthDay.year)) {
            flag = false;
        } else if (Number(curtime.year) == Number(this.birthDay.year)) {
            if (Number(curtime.month) < Number(this.birthDay.month)) {
                flag = false;
            } else if (Number(curtime.month) == Number(this.birthDay.month)) {
                if (Number(curtime.day) < Number(this.birthDay.day)) {
                    flag = false;
                }
            }
        }

        if (!flag) {
            this.feedBack.birthDay = "미래에서 오셨군요. ^^";
            this.validate.birthDay = false;
            return false;
        }
      return true;
    },
    isLeapYear() {
      return (
        (this.birthDay.year % 4 == 0 && this.birthDay.year % 100 != 0) ||
        this.birthDay.year % 400 == 0
      );
    },
    async modify() {
      if (this.chkValidate()) {
        let body = {
          userName: this.form.name,
          birthYear: this.birthDay.year,
          birthMonth: this.birthDay.month,
          birthDay: this.birthDay.day,
          gender: this.form.gender,
        };

        await axios
          .post("/api/users", body)
          .then(() => {
            alert("회원가입 성공!");
            router.push("/loginform");
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    chkValidate() {
      let res = true;
      let key;
      for (key in this.validate) {
        res &= this.validate[key];
        if (!res) {
          this.validate[key] = false;
        }
      }
      return res;
    },
  },
};
</script>

<style>
.full-size {
  width: 100%;
  height: 100%;
}
.text-center {
  text-align: center;
}
.text-left {
  text-align: left;
}
</style>
