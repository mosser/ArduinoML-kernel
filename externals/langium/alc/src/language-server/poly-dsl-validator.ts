import { ValidationAcceptor, ValidationCheck, ValidationRegistry } from 'langium';
import { PolyDslAstType, App } from './generated/ast';
import { PolyDslServices } from './poly-dsl-module';

/**
 * Map AST node types to validation checks.
 */
type PolyDslChecks = { [type in PolyDslAstType]?: ValidationCheck | ValidationCheck[] }

/**
 * Registry for validation checks.
 */
export class PolyDslValidationRegistry extends ValidationRegistry {
    constructor(services: PolyDslServices) {
        super(services);
        const validator = services.validation.PolyDslValidator;
        const checks: PolyDslChecks = {
            App: validator.checkPersonStartsWithCapital
        };
        this.register(checks, validator);
    }
}

/**
 * Implementation of custom validations.
 */
export class PolyDslValidator {

    checkPersonStartsWithCapital(app: App, accept: ValidationAcceptor): void {
        // if (person.name) {
        //     const firstChar = person.name.substring(0, 1);
        //     if (firstChar.toUpperCase() !== firstChar) {
        //         accept('warning', 'Person name should start with a capital.', { node: person, property: 'name' });
        //     }
        // }
    }

}
