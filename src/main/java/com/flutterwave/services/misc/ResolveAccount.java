package com.flutterwave.services.misc;

import com.flutterwave.bean.AccountResolveRequest;
import com.flutterwave.bean.Response;
import com.flutterwave.client.Client;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.RESOLVE_ACCOUNT;
import static com.flutterwave.bean.Verb.POST;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class ResolveAccount {
    private String ERROR = "Error processing request, please check logs";

    public Response runTransaction(AccountResolveRequest accountResolveRequest){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("ACCOUNT_RESOLVE_ENDPOINT"),
                        accountResolveRequest.toString(),
                        POST,
                        RESOLVE_ACCOUNT,
                        null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }
}
