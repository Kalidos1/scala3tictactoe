package model

object FactoryProducer:
  def apply(kind: String): WinStateStrategyTemplate = kind match {
    case "oneD" => OneDGridsStateStrategyFactory().getInstance()
    case "fourD" => FourDGridsStateStrategyFactory().getInstance()
  }


