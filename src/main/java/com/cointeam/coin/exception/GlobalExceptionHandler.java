package com.cointeam.coin.exception;

import com.cointeam.coin.exception.myExceptions.TimeErrorException;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.result.NoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数数据校验格式
     * @param e 拦截的异常
     * @return 返回对象
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult handleValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return CommonResult.paramError(message);
    }

    /**
     * 请求解析异常拦截
     * @param e 拦截的异常
     * @return 返回的对象
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return CommonResult.paramError("请求参数解析异常");
    }

//    @ExceptionHandler(NumberFormatException.class)
//    public CommonResult numberFormatException(NumberFormatException e){
//        return CommonResult.serverError("数字解析异常");
//    }

    @ExceptionHandler(TimeErrorException.class)
    public CommonResult timeErrorException(TimeErrorException e){
        return CommonResult.paramError("时间冲突");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public CommonResult<NoData> MissingServletRequestParameterException(MissingServletRequestParameterException e) {
        String message = e.getParameterName() + " 参数异常";
        return CommonResult.fail(message);
    }
}
