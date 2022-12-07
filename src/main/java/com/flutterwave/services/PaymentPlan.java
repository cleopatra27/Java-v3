package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.PaymentPlanRequest;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.UpdatePaymentPlanRequest;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.PAYMENT_PLAN;
import static com.flutterwave.client.Utility.*;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class PaymentPlan {

    public Response runCreatePlan(PaymentPlanRequest paymentPlanRequest){
        return Optional.of(post(getProperty("PAYMENT_PLAN_BASE"), paymentPlanRequest.toString(),
                        PAYMENT_PLAN, null))
                .map(Response::toResponse).orElseThrow();
    }


    public ListResponse getPlans(){
        return Optional.of(get(getProperty("PAYMENT_PLAN_BASE"),
                        PAYMENT_PLAN, null))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public Response getPlan(int id){
        return Optional.of(get(getProperty("PAYMENT_PLAN_BASE")+"/"+id,
                        PAYMENT_PLAN, null))
                .map(Response::toResponse).orElseThrow();
    }

    public Response cancelPlan(int id){
        return Optional.of(put(getProperty("PAYMENT_PLAN_BASE")+"/"+id+"/cancel", null,
                        PAYMENT_PLAN, null))
                .map(Response::toResponse).orElseThrow();
    }

    public Response updatePlan(int id, UpdatePaymentPlanRequest UpdatePaymentPlanRequest){
        return Optional.of(put(getProperty("PAYMENT_PLAN_BASE")+"/"+id, UpdatePaymentPlanRequest.toString(),
                        PAYMENT_PLAN, null))
                .map(Response::toResponse).orElseThrow();
    }

}
