package com.example.bank_transactions.utility;
import com.example.bank_transactions.dto.AccountDTO;
import com.example.bank_transactions.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO toDTO(Account account);

    List<AccountDTO> toDTOList(List<Account> accounts);

    Account toEntity(AccountDTO accountDTO);

    void updateEntityFromDTO(AccountDTO dto, @MappingTarget Account entity);
}
