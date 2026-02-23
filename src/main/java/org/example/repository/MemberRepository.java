package org.example.repository;

import org.example.model.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    private final Map<String, Member> members = new HashMap<>();

    public void save(Member member) {
        members.put(member.getId(), member);
    }

    public Member findById(String id) {
        return members.get(id);
    }
}
