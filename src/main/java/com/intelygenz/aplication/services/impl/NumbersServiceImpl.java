package com.intelygenz.aplication.services.impl;

import com.intelygenz.aplication.services.NumbersService;
import com.intelygenz.domain.entity.Numbers;
import com.intelygenz.domain.repository.NumbersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class NumbersServiceImpl implements NumbersService {

    private NumbersRepository numbersRepository;

    @Override
    public List<Long> getIntegers(Long id) {
        Numbers numbers = numbersRepository.getReferenceById(id);

        return getIntegersList(numbers.getIntegers())
                .stream()
                .sorted(sortList())
                .toList();
    }

    public List<Long> getIntegersList(String integers) {
        return Stream.of(integers.split(","))
                .map(String::trim)
                .map(Long::parseLong)
                .toList();
    }

    public long getBinaryOnes(Long value) {
        String binary = Integer.toBinaryString(value.intValue());
        return Stream.of(binary.split(""))
                .filter(x -> x.equals("1"))
                .count();
    }

    public Comparator<Long> sortList() {
        return (l1, l2) -> {
            long binary1 = getBinaryOnes(l1);
            long binary2 = getBinaryOnes(l2);

            if (binary1 == binary2) {
                return Math.toIntExact(l1 - l2);
            } else {
                return Math.toIntExact(binary2 - binary1);
            }
        };
    }

}
