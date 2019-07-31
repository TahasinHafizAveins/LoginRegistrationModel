package com.example.loginregistrationmodel.UserRegistration;

import android.util.Patterns;

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private RegistrationContract.View mView;

    RegistrationPresenter(RegistrationContract.View mView) {
        this.mView = mView;
    }

    @Override
    public boolean validate(User user) {

        if (user.getName().isEmpty()) {
            mView.showErrorToast(1, "You Must enter your Name");
            return false;
        }
        if (user.getAddress().isEmpty()) {
            mView.showErrorToast(2, "You Must enter your Address");
            return false;
        }

        if (!Patterns.PHONE.matcher(user.getPhone()).matches()) {
            mView.showErrorToast(3, "You Must enter valid Phone Number");
            return false;
        }

        if (user.getEmail().isEmpty()) {
            mView.showErrorToast(4, "You Must enter your Email");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches()) {
            mView.showErrorToast(4, "You Must enter valid Email");
            return false;
        }

        if (user.getPassword().length() < 6) {
            mView.showErrorToast(5, "Password Length must be more then 6 Letter");
            return false;
        }
        if (!user.getRepassword().equals(user.getPassword())) {
            mView.showErrorToast(6, "Password Doesn't match");
            return false;
        }

        return true;
    }

    @Override
    public void showSuccessToast(String massage) {
        mView.showToastOnSuccess(massage);
        mView.startHomeActivity();
    }
}
