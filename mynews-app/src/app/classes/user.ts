
export enum Role{
    GUEST, USER, ADMIN
}

export class User {
    private id: number;

    public constructor(
        private email: string,
        private name: string,
        private age: number,
        private city: string,
        private password: string,
        private date: Date,
        private role: Role
    ) { }
}
