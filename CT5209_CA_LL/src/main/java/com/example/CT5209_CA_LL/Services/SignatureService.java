package com.example.CT5209_CA_LL.Services;

import com.example.CT5209_CA_LL.Domain.Signature;
import org.springframework.stereotype.Service;

@Service
public class SignatureService {

    public Signature createSignature(String name, String email) {
        return new Signature(name, email);
    }
}
