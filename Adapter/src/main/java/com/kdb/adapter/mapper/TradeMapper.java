package com.kdb.adapter.mapper;

import com.kdb.adapter.messages.ChronicleTradeMsg;
import com.kdb.adapter.messages.KdbTradeMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TradeMapper {

  @Mappings({
    @Mapping(target = "ts", source = "chronicleTradeMessage.ts"),
    @Mapping(target = "time", source = "chronicleTradeMessage.time"),
    @Mapping(target = "sym", source = "chronicleTradeMessage.sym"),
    @Mapping(target = "price", source = "chronicleTradeMessage.price"),
    @Mapping(target = "size", source = "chronicleTradeMessage.size"),
    @Mapping(target = "ex", source = "chronicleTradeMessage.ex")
  })
  KdbTradeMessage sourceToDestination(ChronicleTradeMsg chronicleTradeMessage);

  ChronicleTradeMsg destinationToSource(KdbTradeMessage kdbQuoteMessage);
}
