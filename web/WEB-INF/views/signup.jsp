<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/09/04
  Time: 10:29 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<div class="container-sm ticly__basic-content-layout">
    <div class="login-container">
        <div class="email-signinup-container" id="main-login-form">
            <hearder class="login-header">
                <h1 class="text text-color-gray100 text-weight-medium">이메일로 회원가입</h1>
            </hearder>
            <div class="login-content-wrapper">
                <div class="login-input-group">
                    <label for="signup-email" class="text text-color-gray100 body1 text-weight-medium login-label-title">이메일 <span class="required-label">*</span></label>
                    <input type="text" class="form-control form-control-lg" id="signup-email" name="email" placeholder="ticly@ticly.io" autocomplete=”off”/>
                    <!--이메일 유효성 검사-->
                    <div class="signup-validation-message validation-message"></div>
                </div>
                <div class="login-input-group">
                    <label for="signup-password" class="text text-color-gray100 body1 text-weight-medium login-label-title">비밀번호 <span class="required-label">*</span></label>
                    <input type="password" class="form-control form-control-lg" id="signup-password" name="password" placeholder="비밀번호를 입력해주세요" style="ime-mode:inactive;"/>
                    <div class="eyes-box" id="signup-eyes-box">
                        <i class="icon_show" id="signup-eyes-icon"></i>
                    </div>
                    <!--비밀번호 실시간 유효성 검사-->
                    <div class="signup-validation-message hidden" id="signup-validation-message">
                        <div class="validation-message"><i class="icon_info_circle" id="length-validation-info-icon"></i><p class="text text-color-gray200 body2" id="length-validation-info-message">8자 이상의 비밀번호를 입력해주세요.</p></div>
                        <div class="validation-message"><i class="icon_info_circle" id="number-validation-info-icon"></i><p class="text text-color-gray200 body2" id="number-validation-info-message">영문과 숫자를 포함해주세요.</p></div>
                    </div>
                </div>

                <!--회원가입 약관 동의-->
                <div class="agreements">
                    <div class="agreement-list custom-control custom-checkbox">
                        <input type="checkbox" id="acceptTerm" class="custom-control-input">
                        <label for="acceptTerm" class="custom-control-label text text-color-gray200 text-weight-regular"><a href="#" class="text text-color-gray200 text-weight-bold">서비스 약관</a>과 <a href="#" class="text text-color-gray200 text-weight-bold">개인정보 취급방침</a>에 대해 동의합니다.(필수)</label>
                    </div>
                    <div class="agreement-list custom-control custom-checkbox">
                        <input type="checkbox" id="promotion" class="custom-control-input custom-control">
                        <label for="promotion" class="custom-control-label text text-color-gray200 text-weight-regular">이벤트, 프로모션, 알림 메일 및 SMS수신에 대해 동의합니다.(선택)</label>
                    </div>
                </div>
                <div class="login-modal-button">
                    <button id="signupSubmitBtn" class="btn btn-primary disabled">회원가입</button>
                </div>
            </div>
            <footer class="login-footer">
                <h6 class="text text-color-gray300 text-weight-regular">로그인으로 이동</h6>
                <a href="/member/login" class="text text-color-gray200 text-weight-regular login-footer-moving h6">로그인</a>
            </footer>
        </div>
    </div>
</div>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    (() => {

        let signupEmailElem = document.getElementById('signup-email');  //이메일
        let signupPasswordElem = document.getElementById('signup-password');   //비밀번호

        let signupSubmitBtn = document.getElementById('signupSubmitBtn'); //회원가입 버튼

        const onSignupHandler  = () => {
            const email = signupEmailElem.value;
            const password = signupPasswordElem.value;

            console.log("확인 : " + email + password)

            const member={
                email : email,
                password : password
            };

            axios({
                method: 'post',
                url: '/member/signup.do',
                headers: { 'content-type': 'application/json' },
                data : JSON.stringify(member)
                /*
                params: {
                    email : email,
                    password : password
                }*/
            })
                .then(function (result){
                    alert("가입성공")
                    conesole.log(result);
                    if(result.data.message == "success"){
                        window.location.href="/member/emailSignin";
                    } else {
                        alert("회원가입이 완료되지 않았습니다.");
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        }

        signupSubmitBtn.addEventListener("click", onSignupHandler); //회원가입 버튼 클릭 시 이벤트 핸들러
    })();
</script>
</body>
</html>
