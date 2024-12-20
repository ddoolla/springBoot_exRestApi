package com.example.restapi.business.component;

import com.example.restapi.persistence.user.User;
import com.example.restapi.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProxyEntityManager {

    private final UserRepository userRepository;

    /**
     * 만약 getProxyUserBy 메서드로 얻은 User 의 데이터를 사용하고 싶다면
     * spring.jpa.open-in-view=true 설정(default)을 해주어야한다. 이 설정을 false 로 한다면
     * 지연 로딩 시 no Session 예외가 발생한다. 지연 로딩을 사용하기 위해 위 설정을 true 로 하게되면
     * api 의 요청 ~ 응답까지 영속성 컨텍스트가 유지되고 DB 커넥션이 반환되지 않기 때문에 성능상의 문제가 될 수 있다.
     *
     * 프록시 User 인스턴스의 데이터를 사용하기 위해서는 어차피 로딩이 한 번 이루어져야 한다.
     * 이 프로젝트에서는 해당 데이터를 사용하지 않는다.
     * 어차피 user 데이터를 사용하지 않으면 id 값만 세팅하는 임시 엔터티를 사용하는게 더 간단한 방법인 것 같다.
     */
    public User getProxyUser(Long id) {
        return userRepository.getProxyUserBy(id);
    }
}
