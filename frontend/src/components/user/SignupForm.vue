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
                                :description="description.id"
                                class="mb-3"
                                >
                                <b-row>
                                    <b-col>
                                        <b-form-input
                                    id="input-userId"
                                    v-model="form.userId"
                                    :lazy = "true"
                                    type="email"
                                    maxlength="20"
                                ></b-form-input>
                                    </b-col>
                                </b-row>
                            </b-form-group>
                        </b-col>

                            
            <b-form-group
            id="input-group-password"
            label="비밀번호"
            label-for="input-password"
            :description="description.password"
            class="mb-3"
            >
                <b-form-input
                    id="input-password"
                    v-model="form.email"
                    type="password"
                ></b-form-input>
                
            </b-form-group>

            <b-form-group
            id="input-group-passwordChk"
            label="비밀번호 재확인"
            label-for="input-passwordChk"
            :description="description.passwordChk"
            class="mb-3"
            >
                <b-form-input
                    id="input-passwordChk"
                    v-model="form.passwordChk"
                    type="password"
                ></b-form-input>
            </b-form-group>
        
                <b-form-group id="input-group-name" label="이름:" label-for="input-name" class="mb-3">
                    <b-form-input
                        id="input-name"
                        v-model="form.name"
                    ></b-form-input>
                </b-form-group>
        
                <b-form-group id="input-birthDay-group" label="생년월일" label-for="input-year" class="mb-3">
                    <b-row>
                        <b-col>
                            <b-form-input
                        id="input-year"
                        v-model.number="form.year"
                        type="text"
                        placeholder="년(4자)"
                    ></b-form-input>
                        </b-col>

                        <b-col>
                            <b-form-select class="full-size"
                        id="input-month"
                        v-model="form.month"
                        :options="months"
                    ></b-form-select>
                        </b-col>

                        <b-col>
                            <b-form-input
                        id="input-day"
                        v-model.number="form.day"
                        type="text"
                        placeholder="일"
                    ></b-form-input>
                        </b-col>
                    </b-row>
                </b-form-group>
        
                    <b-form-group id="input-gender-group" label="성별" label-for="input-gender" class="mb-3">
    
                        <b-form-select class="full-size" style="height:40px"
                    id="input-gender"
                    v-model="form.gender"
                    :options="genders"
                    ></b-form-select>
                    </b-form-group>
                        <b-row>
                            <b-col ></b-col>
                            <b-col sm="3">
                                <b-button variant="success">가입하기</b-button>
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
let axios = apiInstance();
  export default {
    data() {
      return {
        form: {
          userId: '',
              password: '',
          passwordChk:'',
              year:'',
              month:null,
              day:'',
              gender: null,
              phoneNumber: '',
          },
          months: [{ text: '월', value: null }, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
          genders: [{ text: '성별', value: null },"남","여","선택안함"],
          description: {
            id:''
          }
      }
    },
    watch: {
        'form.userId': function () {
            console.log(this.form.userId);
            this.idValidChk();
        }
    },
    methods: {
        async idValidChk() {
            if (this.form.userId.length == 0) {
                this.description.id = "필수 사항입니다."
                return;
            }
            let flag = true;
            if (this.form.userId.length < 5 || this.form.userId.length > 20)
                flag = false;
            else {
                let i = this.form.userId.length;
                while (i--) {
                    let c = this.form.userId[i];
                    if (!(c >= 'a' && c <= 'z'))
                    if (!(c >= '0' && c <= '9'))
                    if (!(c == '_' || c == '-'))
                    {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) {
                this.description.id = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다."
                return;
            } else {
                if(await this.idDuplicateChk(this.form.userId)) {
                    this.description.id = "멋진 아이디네용 ㅋ";    
                } else {
                    this.description.id = "중복 된 아이디입니다.";
                }
            }
        },
        async idDuplicateChk() {
            return await axios.get('api/users/id', { params: { userId: this.form.userId } }).then(({ status }) => {
                if (status == 200)
                    return true;
            }).catch(({ status }) => {
                if (status == 409)
                    return false;
            })
        }
    }
  }
</script>

<style>
    .full-size{
        width: 100%; height: 100%;
    }
    .text-center{
        text-align: center;
    }
    .text-left{
        text-align: left;
    }
</style>