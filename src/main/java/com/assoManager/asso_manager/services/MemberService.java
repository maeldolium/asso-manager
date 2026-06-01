package com.assoManager.asso_manager.services;

import com.assoManager.asso_manager.repository.HoursLogRepository;
import com.assoManager.asso_manager.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.assoManager.asso_manager.models.Member;
import com.assoManager.asso_manager.models.HoursLog;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final HoursLogRepository hoursRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, HoursLogRepository hoursRepository) {
        this.memberRepository = memberRepository;
        this.hoursRepository = hoursRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }

    public Member addHoursLog(HoursLog log){
        // Sauvegarder le log en base
        HoursLog savedLog = hoursRepository.save(log);

        // Récupérer le membre
        Member member = savedLog.getMember();

        // Mettre à jour la valeur sur le membre
        member.setTotalHours(member.getTotalHours() + savedLog.getHours());

        // Sauvegarder le membre à jour
        memberRepository.save(member);

        return member;

    }

}
