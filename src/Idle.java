class Idle extends State {
	@Override
	public State monkeyUp(Monkey monkey) {

		int y = monkey.getMonkeyY();

		if (y > 0) {

			monkey.setMonkeyY(monkey.getMonkeyY() - 32);

		}

		return new Moving();

	}

	@Override
	public State monkeyDown(Monkey monkey) {

		int y = monkey.getMonkeyY();
		if (y < 640 - 32) {

			monkey.setMonkeyY(monkey.getMonkeyY() + 32);

		}

		return new Moving();
	}

	@Override
	public State monkeyRight(Monkey monkey) {

		int x = monkey.getMonkeyX();

		if (x < 640 - 32) {

			monkey.setMonkeyX(monkey.getMonkeyX() + 32);

		}

		return new Moving();
	}

	@Override
	public State monkeyLeft(Monkey monkey) {

		int x = monkey.getMonkeyX();

		if (x > 0) {

			monkey.setMonkeyX(monkey.getMonkeyX() - 32);

		}

		return new Moving();
	}

}