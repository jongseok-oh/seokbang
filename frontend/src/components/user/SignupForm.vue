<template>
  <div class="mt-5 mb-5">
    <b-row>
      <b-col></b-col>
      <b-col>
        <b-card>
          <b-row class="mt-3 mb-3 text-left">
            <b-col sm="1"></b-col>
            <b-col>
              <h3 class="mb-5">회원가입</h3>
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
                        :lazy="true"
                        type="email"
                        maxlength="20"
                        :state="validate.id"
                      ></b-form-input>
                      <b-form-invalid-feedback :state="validate.id">
                        {{ feedBack.id }}
                      </b-form-invalid-feedback>
                      <b-form-valid-feedback :state="validate.id">
                        {{ feedBack.id }}
                      </b-form-valid-feedback>
                    </b-col>
                  </b-row>
                </b-form-group>
              </b-col>

              <b-form-group
                id="input-group-password"
                label="비밀번호"
                label-for="input-password"
                class="mb-3"
              >
                <b-form-input
                  id="input-password"
                  v-model="form.password"
                  :lazy="true"
                  type="password"
                  :state="validate.password"
                  maxlength="16"
                ></b-form-input>
                <b-form-invalid-feedback :state="validate.password">
                  {{ feedBack.password }}
                </b-form-invalid-feedback>
                <b-form-valid-feedback :state="validate.password">
                  {{ feedBack.password }}
                </b-form-valid-feedback>
              </b-form-group>

              <b-form-group
                id="input-group-passwordChk"
                label="비밀번호 재확인"
                label-for="input-passwordChk"
                class="mb-3"
              >
                <b-form-input
                  id="input-passwordChk"
                  v-model="form.passwordChk"
                  :lazy="true"
                  type="password"
                  :state="validate.passwordChk"
                  maxlength="16"
                ></b-form-input>
                <b-form-invalid-feedback :state="validate.passwordChk">
                  {{ feedBack.passwordChk }}
                </b-form-invalid-feedback>
                <b-form-valid-feedback :state="validate.passwordChk">
                  {{ feedBack.passwordChk }}
                </b-form-valid-feedback>
              </b-form-group>

              <b-form-group id="input-group-name" label="이름:" label-for="input-name" class="mb-3">
                <b-form-input
                  id="input-name"
                  v-model="form.name"
                  :lazy="true"
                  :state="validate.name"
                  maxlength="40"
                ></b-form-input>
                <b-form-invalid-feedback :state="validate.name">
                  {{ feedBack.name }}
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
                  <b-button variant="success" @click="registor">가입하기</b-button>
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

let axios = apiInstance();

const requiredMsg = "필수 정보입니다.";
const passwordTest = /^(?=.*[a-zA-Z])((?=.*\d)(?=.*\W)).{8,16}$/;
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
        password: "",
        passwordChk: "",
        gender: null,
        phoneNumber: "",
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
        password: requiredMsg,
        passwordChk: requiredMsg,
        name: requiredMsg,
        birthDay: requiredMsg,
        gender: requiredMsg,
      },
      validate: {
        id: null,
        password: null,
        passwordChk: null,
        name: null,
        birthDay: null,
        gender: null,
      },
    };
  },
  watch: {
    "form.userId": async function () {
      console.log(this.form.userId);
      this.validate.id = await this.isValidId();
      console.log(this.validate);
    },
    "form.password": function () {
      this.validate.password = this.isValidPassword();
    },
    "form.passwordChk": function () {
      this.validate.passwordChk = this.isValidPasswordChk();
    },
    "form.name": function () {
      this.validate.name = this.isValidName();
    },
    "birthDay.year": async function () {
      this.validate.birthDay = await this.isValidBirthDay();
    },
    "birthDay.month": async function () {
      this.validate.birthDay = await this.isValidBirthDay();
    },
    "birthDay.day": async function () {
      this.validate.birthDay = await this.isValidBirthDay();
    },
    "form.gender": function (newval, oldval) {
      this.validate.gender = !newval ? false : true;
    },
  },
  methods: {
    async isValidId() {
      let uId = this.form.userId.length;
      if (!uId || uId == 0) {
        this.feedBack.id = requiredMsg;
        return false;
      }
      let flag = true;
      if (uId < 5 || uId > 20) flag = false;
      else {
        let i = uId.length;
        while (i--) {
          let c = uId[i];
          if (!(c >= "a" && c <= "z"))
            if (!(c >= "0" && c <= "9"))
              if (!(c == "_" || c == "-")) {
                flag = false;
                break;
              }
        }
      }
      if (!flag) {
        this.feedBack.id = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        return false;
      } else {
        if (await this.idDuplicateId(uId)) {
          this.feedBack.id = "멋진 아이디네용 ㅋ";
          return true;
        } else {
          this.feedBack.id = "중복 된 아이디입니다.";
          return false;
        }
      }
    },
    async idDuplicateId() {
      return await axios
        .get("api/users/id", { params: { userId: this.form.userId } })
        .then(({ status }) => {
          if (status == 200) return true;
        })
        .catch(({ status }) => {
          if (status == 409) return false;
        });
    },
    isValidPassword() {
      let pw = this.form.password;

      if (!pw || pw.length == 0) {
        this.feedBack.password = requiredMsg;
        return false;
      }
      if (!passwordTest.test(pw)) {
        this.feedBack.password = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        return false;
      }
      this.feedBack.password = "안전한 비밀번호입니다.";
      return true;
    },
    isValidPasswordChk() {
      let pwck = this.form.passwordChk;
      if (!pwck || pwck.length == 0) {
        this.feedBack.passwordChk = requiredMsg;
        return false;
      }
      if (pwck != this.form.password) {
        this.feedBack.passwordChk = "비밀번호가 일치하지 않습니다.";
        return false;
      } else {
        this.feedBack.passwordChk = "일치합니다.";
        return true;
      }
    },
    isValidName() {
      let nameck = this.form.name;
      if (!nameck || nameck.length == 0) {
        this.feedBack.name = requiredMsg;
        return false;
      }
      if (!nameTest.test(nameck)) {
        this.feedBack.name = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        return false;
      }
      return true;
    },
    async isValidBirthDay() {
      let birthDaychk = this.birthDay;

      // year check
      if (!birthDaychk.year || birthDaychk.year.length != 4 || !numberTest.test(birthDaychk.year)) {
        this.validate.birthDay = false;
        this.feedBack.birthDay = "태어난 년도 4자리를 정확하게 입력하세요.";
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
        Number(birthDaychk.day) > maxDay||
        Number(birthDaychk.day) <= 0
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

        if (Number(curtime[0]) < Number(this.birthDay.year)) {
            flag = false;
        } else if (Number(curtime[0]) == Number(this.birthDay.year)) {
            if (Number(curtime[1]) < Number(this.birthDay[1])) {
                flag = false;
            } else if (Number(curtime[1]) == Number(this.birthDay[1])) {
                if (Number(curtime[2]) < Number(this.birthDay[2])) {
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
    async registor() {
      if (this.chkValidate()) {
        let body = {
          userId: this.form.userId,
          password: this.form.password,
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
