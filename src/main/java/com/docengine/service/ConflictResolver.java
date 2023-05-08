package com.docengine.service;
import com.docengine.crdt.LWWRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class ConflictResolver {
    public String resolve(String op1, String op2, String nodeId) {
        LWWRegister<String> reg1 = new LWWRegister<>(op1, "node1");
        LWWRegister<String> reg2 = new LWWRegister<>(op2, "node2");
        LWWRegister<String> resolved = reg1.merge(reg2);
        return resolved.getValue();
    }
}
